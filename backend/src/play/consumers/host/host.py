from asgiref.sync import async_to_sync
from channels.generic.websocket import WebsocketConsumer
from . import actions
from play.game.game import Game
from play.game.state import State

import json

class HostConsumer(WebsocketConsumer):
    def connect(self):
        self.game_token = self.scope['url_route']['kwargs']['game_token']
        self.host_group_name = 'host_%s' % self.game_token
        self.players_group_name = 'players_%s' % self.game_token
        self.game = Game(self.game_token)

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
        self.game.deactivate()

    # Receive message from WebSocket
    def receive(self, text_data):
        text_data_json = json.loads(text_data)
        message = text_data_json['message']

        # receiving a message from the front end means
        # to proceed to the next step of the game

    def registration_message(self, event):
        name = event['name']
        print(f'event: {event}')
        new_player = {'channel':name, 'name':'', 'state':'naming'}
        self.game.add_player(new_player)
        print(f'registered {name}')
        message = 'waiting for game to start...'
        self.send_to_player(name, State.POST_REGISTRATION, message)

    def answer_message(self, event):
        name = event['name']
        print(f'event: {event}')
        # record player's answer...
        message = 'waiting for everyone to answer...'
        self.send_to_player(name, State.STANDBY, message)

    def send_to_player(self, name, state, data={}, type='change_state_message'):
        async_to_sync(self.channel_layer.send)(
            name,
            {
                'type': type,
                'state': state,
                'data': data
            }
        )

    def send_to_all_players(self, state, data={}, type='change_state_message'):
        async_to_sync(self.channel_layer.group_send)(
            self.players_group_name,
            {
                'type': type,
                'state': state,
                'data': data
            }
        )
