from game.models import Game, ActiveGame
from question.models import Question, QuestionGame, QuestionAnswerOption
from .state import State
import time
from math import ceil

class Game:
    def __init__(self, game_token):
        self.active_game = None
        self.questions, self.answers, self.question_hooks, self.scoring_hook = self.get_game(game_token)
        self.players = {}
        self.teamCount = None
        self.teams = None
        self.states = self.make_game()
        self.scores = {}
        self.output = self.reset_output()
        self.start_time = None
        self.round_results = {}
        self.calculate_score = self.custom_individual_scoring if self.scoring_hook else self.default_individual_scoring

    def custom_individual_scoring(self, result):
        exec(self.scoring_hook, {'results': result})

    def default_individual_scoring(self, result):
        time = self.get_question()['time']
        return ceil((time-result['time'])/time*1000)

    def make_game(self):
        states = [State.REGISTRATION, State.POST_REGISTRATION]
        for i in range(0,len(self.questions)):
            states += [State.PRE_QUESTION,State.QUESTION,State.POST_QUESTION]
        states += [State.FINISHED, State.GAME_OVER]
        return states

    # [{id, text, time, answers[option, option,...]},...], [['yes'], ['hi', 'ho'],...]
    def get_game(self, game_token):
        self.active_game = ActiveGame.objects.get(slug=game_token)
        qg = QuestionGame.objects.all().select_related('game', 'question').filter(game=self.active_game.game)

        scoring_hook = None
        questions = []
        answers = []
        hooks = []

        scoring = qg.first().game.scoring
        if scoring:
            scoring_hook = scoring.hook

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
            hooks.append([e.pre_question_hook, e.post_question_hook])
            questions.append(question)
        return questions, answers, hooks, scoring_hook

    def check_answer(self, answer):
        return answer in self.answers[0]

    def next_question(self):
        self.answers.pop(0)
        self.question_hooks.pop(0)
        self.questions.pop(0)
        return self.get_question()

    def get_question(self):
        if len(self.questions) == 0:
                return None
        return self.questions[0]

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
        for channel in player:
            self.players[channel] = player[channel]
            self.scores[channel] = 0

    def deactivate(self):
        self.active_game.delete()

    def post_registration(self):
        pass

    def pre_question(self):
        exec(self.question_hooks[0][0])

    def post_question(self):
        exec(self.question_hooks[0][1])

    def get_results(self):
        return 1

    def score_answer(self, channel, answer):
        time_taken = time.time() - self.start_time
        correct = self.check_answer(answer)
        score = 0
        if correct:
            score = self.calculate_score({'answer':answer, 'time': time_taken, 'correct': correct})
        self.round_results[channel] = {'answer':answer, 'time': time_taken, 'correct': correct, 'score': score}
        self.scores[channel] += score

    def all_answers_in(self):
        return len(self.round_results) == len(self.players)

    def reset_output(self):
        return {'players': {'data': None}, 'group': {'data': None}, 'host': {'data': None, 'timer': None}}

    def reset_round_results(self):
        for channel in self.players:
            self.round_results[channel] = {'answer': None, 'time': None, 'correct': False, 'score': 0}

    def generate_leaderboard(self):
        return {'scores': self.scores, 'roundResults': self.round_results}, self.round_results

    def change_state(self, new_state):
        self.output = self.reset_output()
        if new_state is State.REGISTRATION:
            print('registration method')
            pass
        elif new_state is State.POST_REGISTRATION:
            print('post registration method')
            self.post_registration()
        elif new_state is State.PRE_QUESTION:
            print('pre question method')
            self.pre_question()
        elif new_state is State.QUESTION:
            print('asking question...')
            self.output['host']['data'] = self.output['group']['data'] = self.get_question()
            self.reset_round_results()
            self.start_time = time.time()
        elif new_state is State.POST_QUESTION:
            print('post question method')
            self.output['host']['data'], self.output['players']['data'] = self.generate_leaderboard()
            self.post_question()
            self.next_question()
        elif new_state is State.FINISHED:
            print('calculating results')
            self.output['host']['data'] = self.get_results()
        else:
            print('passing')

        if self.output['host']['data'] or self.output['group']['data'] or self.output['players']['data']:
            return self.output
        return self.change_state(self.next_state())