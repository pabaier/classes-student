from enum import Enum

class State(str, Enum):
    CONNECT = 'connect'
    REGISTRATION = 'registration'
    POST_REGISTRATION = 'postRegistration'
    PRE_QUESTION = 'preQuestion'
    QUESTION = 'question'
    STANDBY = 'standby'
    POST_QUESTION = 'postQuestion'
    FINISHED = 'finished'
    GAME_OVER = 'gameOver'