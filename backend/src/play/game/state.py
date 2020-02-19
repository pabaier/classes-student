from enum import Enum

class State(str, Enum):
    REGISTRATION = 'registration'
    POST_REGISTRATION = 'post_registration'
    PRE_QUESTION = 'pre_question'
    QUESTION = 'question'
    STANDBY = 'standby'
    POST_QUESTION = 'post_question'
    FINISHED = 'finished'
    GAME_OVER = 'game_over'