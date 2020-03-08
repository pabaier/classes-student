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
        self.round_results = []

        # Join room group
        async_to_sync(self.channel_layer.group_add)(
            self.host_group_name,
            self.channel_name
        )

        self.accept()
        self.send_to_frontend(State.CONNECT, {'message': 'waiting for connections and registrations...'})

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

        if output['host']['data']:
            self.send_to_frontend(current_state, output['host'])
        if output['group']['data']:
            self.send_to_group(current_state, output['group'])
        elif output['players']['data']:
            self.send_to_all_individual_players(current_state, output['players'])

    def connect_message(self, event):
        channel = event['channel']
        print(f'event: {event}')
        new_player = {channel: {'name':'', 'state':'naming'}}
        self.game.add_player(new_player)
        print(f'connected {channel}')
        message = 'now register...'
        self.send_to_player(channel, State.REGISTRATION, message)

    def registration_message(self, event):
        channel = event['channel']
        print(f'event: {event}')
        name = event['data']
        self.game.set_player_name(channel, name)
        message = f'welcome {name}'
        self.send_to_player(channel, self.game.get_state(), message)

    def answer_message(self, event):
        channel = event['channel']
        answer = event['data']
        all_answers_in = self.game.score_answer(channel, answer)
        if all_answers_in:
            self.receive(json.dumps({'message': 'done'}))
        else:
            message = 'waiting for everyone to answer...'
            self.send_to_player(channel, State.STANDBY, message)

    def send_to_player(self, channel, state, data={}, type='change_state_message'):
        async_to_sync(self.channel_layer.send)(
            channel,
            {
                'type': type,
                'state': state,
                'data': data
            }
        )

    def send_to_group(self, state, data={}, type='change_state_message'):
        async_to_sync(self.channel_layer.group_send)(
            self.players_group_name,
            {
                'type': type,
                'state': state,
                'data': data
            }
        )

    def send_to_all_individual_players(self, state, players={}, type='change_state_message'):
        for channel in players['data']:
            self.send_to_player(channel, state, players['data'][channel])

    def send_to_frontend(self, state, data={}):
        self.send(text_data=json.dumps({
            'state': state,
            'data': data
        }))