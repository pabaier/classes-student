from enum import Enum

class State(Enum):
    REGISTRATION=0
    PRE_QUESTION=1
    QUESTION=2
    POST_QUESTION=3
    FINISHED=4

class Game:
    def __init__(self):
        self.questions = None
        self.players = None
        self.teamCount = None
        self.teams = None
        self.state = State.REGISTRATION

    def set_questions(self, questions):
        self.questions = questions
        return self

    def set_number_of_players(self, num):
        self.playerCount = num
        return self

    def set_number_of_teams(self, num):
        self.teamCount = num
        return self

    # >>> a = Game()
    # >>> a.set_number_of_players(3).set_number_of_teams(2)
    # <play.game.game.Game object at 0x7fe159e959b0>
    # >>> a.players = ['jimmy', 'timmy', 'whinny']
    # >>> def b (me):
    # ...     me.teams = {'a': [me.players[0]], 'b': [me.players[1], me.players[2]]}
    # >>> a.set_teams(b)
    # >>> a.teams
    # {'a': ['jimmy'], 'b': ['timmy', 'whinny']}
    # the idea behind this function is to have the user define their own function for setting the teams and this will
    # simply run the function. The user's function can expect this object as a parameter. The lambda needs to set the
    # `self.teams` property
    def set_teams(self, set_teams_lambda):
        set_teams_lambda(self)

    def pre_question(self, pre_question_lambda):
        pre_question_lambda(self)

    def change_states(self, new_state):
        switcher = {
            State.REGISTRATION: '1',
            State.PRE_QUESTION: '2',
            State.QUESTION: '3',
            State.POST_QUESTION: '4',
            State.FINISHED: '5'
        }
        switcher[new_state]
