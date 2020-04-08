from enum import Enum


class State(str, Enum):
    HOOK = 'hook'
    REGISTRATION = 'registration'
    MAKE_TEAMS = 'makeTeams'
    QUESTION = 'question'
    STANDBY = 'standby'
    POST_QUESTION = 'postQuestion'
    FINISHED = 'finished'
    GAME_OVER = 'gameOver'


class GameState:
    def __init__(self, state, has_pre_hook=False, has_post_hook=False):
        self.has_pre_hook = has_pre_hook
        self.state = state
        self.has_post_hook = has_post_hook
