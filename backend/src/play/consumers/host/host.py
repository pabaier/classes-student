from asgiref.sync import async_to_sync
from channels.generic.websocket import WebsocketConsumer
from game.models import ActiveGame
from . import actions

import json

class HostConsumer(WebsocketConsumer):
    def connect(self):
        self.game_token = self.scope['url_route']['kwargs']['game_token']
        self.host_group_name = 'host_%s' % self.game_token
        self.players_group_name = 'players_%s' % self.game_token
        self.player_list = []

        # Join room group
        async_to_sync(self.channel_layer.group_add)(
            self.host_group_name,
            self.channel_name
        )

        self.accept()

    def disconnect(self, close_code):
        # Leave room group
        async_to_sync(self.channel_layer.group_discard)(
            self.host_group_name,
            self.channel_name
        )
        ActiveGame.objects.filter(slug=self.game_token).delete()

    # Receive message from WebSocket
    def receive(self, text_data):
        text_data_json = json.loads(text_data)
        message = text_data_json['message']
        type = text_data_json['type']

        # Send message to room group
        async_to_sync(self.channel_layer.group_send)(
            self.players_group_name,
            {
                'type': 'chat_message',
                'message': message
            }
        )

    def registration_message(self, event):
        name = event['name']
        print(f'event: {event}')
        new_player = {'channel_name':name, 'player_name':'', 'state':'naming'}
        self.player_list.append(new_player)
        print(f'registered {name}')

        print(f'{self.player_list}')

        # async_to_sync(self.channel_layer.send)(
        #     name,
        #     {
        #         'type': 'chat_message',
        #         'message': 'you are now registered'
        #     }
        # )

    # Receive message from room group
    def chat_message(self, event):
        message = event['message']

        # Send message to WebSocket
        self.send(text_data=json.dumps({
            'message': message
        }))