from game.models import Game, ActiveGame
from question.models import Question, QuestionGame, QuestionAnswerOption
from .state import State

class Game:
    def __init__(self, game_token):
        self.active_game = None
        self.questions, self.answers = self.get_questions_and_answers(game_token)
        self.players = []
        self.teamCount = None
        self.teams = None
        self.states = self.make_game()
        self.results = []
        self.output = None

    def make_game(self):
        states = [State.REGISTRATION, State.POST_REGISTRATION]
        for i in range(0,len(self.questions)):
            states += [State.PRE_QUESTION,State.QUESTION,State.POST_QUESTION]
        states += [State.FINISHED, State.GAME_OVER]
        return states

    # [{id, text, time, answers[option, option,...]},...], [['yes'], ['hi', 'ho'],...]
    def get_questions_and_answers(self, game_token):
        self.active_game = ActiveGame.objects.get(slug=game_token)
        qg = QuestionGame.objects.all().select_related('game', 'question').filter(game=self.active_game.game)
        questions = []
        answers = []
        for e in qg:
            answerOptions = QuestionAnswerOption.objects.all().select_related('question').filter(question=e.question)
            question = {
                'id': e.question.id,
                'text': e.question.text,
                'time': e.time_limit
            }
            answerOptionList = []
            answer = []
            for a in answerOptions:
                answerOptionList.append(a.option)
                if a.isAnswer:
                    answer.append(a.option)
            question['answers']=answerOptionList
            answers.append(answer)
            questions.append(question)
        return (questions, answers)

    def check_answer(self, answer):
        return answer in self.answers[0]

    def next_question(self):
        self.answers.pop(0)
        return self.questions.pop(0)

    def next_state(self):
        self.states.pop(0)
        return self.get_state()

    def get_state(self):
        if len(self.states) == 0:
            return None
        return self.states[0]

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

    def add_player(self, player):
        self.players.append(player)

    def deactivate(self):
        self.active_game.delete()

    def post_registration(self):
        pass

    def pre_question(self):
        # get and execute code from db
        pass

    def post_question(self):
        # get and execute code from db
        pass

    def get_results(self):
        return 1

    def change_state(self, new_state):
        self.output = None
        if new_state is State.REGISTRATION:
            pass
        elif new_state is State.POST_REGISTRATION:
            print('post registration method')
            self.post_registration()
        elif new_state is State.PRE_QUESTION:
            print('pre question method')
            self.pre_question()
        elif new_state is State.QUESTION:
            print('asking question...')
            self.output = self.next_question()
        elif new_state is State.POST_QUESTION:
            print('post question method')
            self.post_question()
        elif new_state is State.FINISHED:
            print('calculating results')
            self.output = self.get_results()
        else:
            print('passing')

        if self.output:
            return self.output
        return self.change_state(self.next_state())