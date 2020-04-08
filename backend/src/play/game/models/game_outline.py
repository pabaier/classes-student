import json

from .states import GameState, State


class GameOutline:
    def __init__(self, states=[]):
        self.states = states
        self.past_states = []
        self.current_state = None

    def add_state(self, state):
        self.states.append(state)

    def add_states(self, states):
        self.states += states

    def get_current_state(self) -> GameState:
        return self.current_state

    def next_state(self) -> GameState:
        state = self.states.pop(0)
        self.past_states.append(state)
        self.current_state = state
        return state

    def previous_state(self):
        state = self.past_states.pop(len(self.past_states) - 1)
        self.states.insert(0, self.current_state)
        self.current_state = state

    def to_json_string(self):
        return json.dumps(self.states, default=lambda x: x.__dict__)

    @staticmethod
    def create_game_outline(gameOutlineString):
        game_outline = GameOutline()
        game_states_dict = json.loads(gameOutlineString)
        for state in game_states_dict:
            game_state = GameState(
                State(state['state']),
                state['has_pre_hook'],
                state['has_post_hook']
            )
            game_outline.states.append(game_state)
        return game_outline
