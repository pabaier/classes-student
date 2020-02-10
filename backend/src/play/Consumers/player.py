from asgiref.sync import async_to_sync
from channels.generic.websocket import WebsocketConsumer
import json

class PlayerConsumer(WebsocketConsumer):
    def connect(self):
        self.game_token = self.scope['url_route']['kwargs']['game_token']
        self.host_group_name = 'host_%s' % self.game_token
        self.players_group_name = 'players_%s' % self.game_token

        # Join room group
        async_to_sync(self.channel_layer.group_add)(
            self.players_group_name,
            self.channel_name
        )

        self.accept()

    def disconnect(self, close_code):
        # Leave room group
        async_to_sync(self.channel_layer.group_discard)(
            self.players_group_name,
            self.channel_name
        )

    # Receive message from WebSocket
    def receive(self, text_data):
        text_data_json = json.loads(text_data)
        message = text_data_json['message']

        # Send message to room group
        async_to_sync(self.channel_layer.group_send)(
            self.host_group_name,
            {
                'type': 'chat_message',
                'message': message
            }
        )

    # Receive message from room group
    def chat_message(self, event):
        message = event['message']

        # Send message to WebSocket
        self.send(text_data=json.dumps({
            'message': message
        }))