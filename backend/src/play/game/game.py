from game.models import Game, ActiveGame
from question.models import Question, QuestionGame, QuestionAnswerOption
from .state import State

class Game:
    def __init__(self, game_token):
        self.active_game = None
        self.questions = self.get_questions(game_token)
        self.question_index = 0
        self.players = []
        self.teamCount = None
        self.teams = None
        self.state = State.REGISTRATION
        self.results = []

    # [{id, text, time, answers{option:true}},...]
    def get_questions(self, game_token):
        self.active_game = ActiveGame.objects.get(slug=game_token)
        qg = QuestionGame.objects.all().select_related('game', 'question').filter(game=self.active_game.game)
        questions = []
        for e in qg:
            answerOptions = QuestionAnswerOption.objects.all().select_related('question').filter(question=e.question)
            question = {
                'id': e.question.id,
                'text': e.question.text,
                'time': e.time_limit
            }
            answers = {}
            for a in answerOptions:
                answers[a.option] = a.isAnswer
            question['answers']=answers
            questions.append(question)
        return questions

    def get_next_question(self):
        self.question_index += 1
        return self.questions[self.question_index-1]

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

    def pre_question(self):
        # get and execute code from db
        pass

    def change_states(self, new_state):
        if new_state is State.REGISTRATION:
            pass
        elif new_state is State.POST_REGISTRATION:
            pass
        elif new_state is State.PRE_QUESTION:
            return self.pre_question()
        elif new_state is State.QUESTION:
            return self.get_next_question()
        elif new_state is State.POST_QUESTION:
            pass
        elif new_state is State.FINISHED:
            pass
        else:
            pass

    def add_player(self, player):
        self.players.append(player)

    def deactivate(self):
        self.active_game.delete()