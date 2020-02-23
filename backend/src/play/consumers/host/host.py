from asgiref.sync import async_to_sync
from channels.generic.websocket import WebsocketConsumer
from play.game.game import Game
from play.game.state import State
import json

class HostConsumer(WebsocketConsumer):
    def connect(self):
        self.game_token = self.scope['url_route']['kwargs']['game_token']
        self.host_group_name = 'host_%s' % self.game_token
        self.players_group_name = 'players_%s' % self.game_token
        self.game = Game(self.game_token)
        self.game.set_times_up_function(self.send_to_frontend)
        self.round_results = []

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
        new_state = self.game.next_state()

        output = self.game.change_state(new_state)
        current_state = self.game.get_state()

        self.send_to_all_players(current_state, output)
        self.send_to_frontend(current_state, output)

    def registration_message(self, event):
        name = event['name']
        print(f'event: {event}')
        new_player = {'channel':name, 'name':'', 'state':'naming'}
        self.game.add_player(new_player)
        print(f'registered {name}')
        message = 'waiting for game to start...'
        self.send_to_player(name, self.game.get_state(), message)

    def answer_message(self, event):
        name = event['name']
        answer = event['data']
        self.game.log_answer(name, answer)
        if self.game.all_answers_in():
            self.receive(json.dumps({'message': 'done'}))
        else:
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

    def send_to_frontend(self, state, data={}):
        self.send(text_data=json.dumps({
            'state': state,
            'data': data
        }))