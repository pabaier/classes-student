from game.models import Game, ActiveGame
from question.models import Question, QuestionGame, QuestionAnswerOption
from .state import State
import time
from math import ceil, floor
import random

class Game:
    def __init__(self, game_token, isTeam, number_of_teams = 2):
        self.isTeam = isTeam
        self.active_game = None
        self.questions, self.answers, self.question_hooks, self.individual_scoring_hook, self.team_scoring_hook, self.post_registration_hook = self.get_game(game_token)
        self.players = {}
        self.teams = {}
        self.number_of_teams = number_of_teams
        self.states = self.make_game()
        self.output = self.reset_output()
        self.start_time = None
        self.calculate_individual_score = self.set_individual_scoring_function()
        self.calculate_team_score = self.set_team_scoring_function()
        self.number_of_answers = 0
        self.custom_individual_scoring_return = 0

    def set_team_scoring_function(self):
        if self.team_scoring_hook:
            return self.custom_team_scoring
        return self.default_team_scoring

    def custom_team_scoring(self):
        exec(self.team_scoring_hook)

    def default_team_scoring(self):
        pass

    def set_individual_scoring_function(self):
        if self.individual_scoring_hook:
            return self.custom_individual_scoring
        return self.default_individual_scoring

    def custom_individual_scoring(self, result, channel):
        exec(self.individual_scoring_hook, {'results': result, 'channel': channel, 'self': self})
        return self.custom_individual_scoring_return

    def default_individual_scoring(self, result, channel):
        time = self.get_question()['time']
        score = ceil((time-result['time'])/time*1000)
        if score < 100:
            score = 100
        return score

    def make_game(self):
        states = [State.REGISTRATION, State.MAKE_TEAMS, State.POST_REGISTRATION]
        for i in range(0,len(self.questions)):
            states += [State.PRE_QUESTION,State.QUESTION,State.POST_QUESTION]
        states += [State.FINISHED, State.GAME_OVER]
        return states

    # [{id, text, time, answers[option, option,...]},...], [['yes'], ['hi', 'ho'],...]
    def get_game(self, game_token):
        self.active_game = ActiveGame.objects.get(slug=game_token)
        qg = QuestionGame.objects.all().select_related('game', 'question').filter(game=self.active_game.game)

        individual_scoring_hook = None
        team_scoring_hook = None
        post_registration_hook = None
        questions = []
        answers = []
        hooks = []

        team_scoring = qg.first().game.team_scoring_hook
        if team_scoring:
            team_scoring_hook = team_scoring.code
        individual_scoring = qg.first().game.individual_scoring_hook
        if individual_scoring:
            individual_scoring_hook = individual_scoring.code

        post_registration = qg.first().game.post_registration_hook
        if post_registration:
            post_registration_hook = post_registration.code

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
            hooks_pair = ['', '']
            if e.pre_hook:
                hooks_pair[0] = e.pre_hook.code
            if e.post_hook:
                hooks_pair[1] = e.pre_hook.code
            hooks.append(hooks_pair)
            questions.append(question)
        return questions, answers, hooks, individual_scoring_hook, team_scoring_hook, post_registration_hook

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

    def add_player(self, channel):
        self.players[channel] = {'name':'', 'totalScore':0, 'roundResult': self.empty_round_result(), 'rank':0}

    def set_player_name(self, channel, name):
        self.players[channel]['name'] = name

    def deactivate(self):
        self.active_game.delete()

    def post_registration(self):
        if(self.post_registration_hook):
            exec(self.post_registration_hook)

    def pre_question(self):
        if(self.question_hooks[0][0]):
            exec(self.question_hooks[0][0])

    def post_question(self):
        if(self.question_hooks[0][1]):
            exec(self.question_hooks[0][1])

    def get_results(self):
        return self.generate_leaderboard()

    def score_answer(self, channel, answer):
        player = self.players[channel]
        time_taken = time.time() - self.start_time
        correct = self.check_answer(answer)
        score = 0
        if correct:
            score = self.calculate_individual_score({'answer':answer, 'time': time_taken, 'correct': correct}, channel)
        player['roundResult'] = {'answer':answer, 'time': time_taken, 'correct': correct, 'score': score}
        player['totalScore'] += score
        self.number_of_answers += 1
        all_in = self.all_answers_in()
        if all_in:
            self.number_of_answers = 0
        return all_in

    def all_answers_in(self):
        return len(self.players) == self.number_of_answers

    def reset_output(self):
        return {'players': {'data': None}, 'group': {'data': None}, 'host': {'data': None, 'timer': None}}

    def reset_round_results(self):
        for channel in self.players:
            self.players[channel]['roundResult'] = self.empty_round_result()

    @staticmethod
    def empty_round_result():
        return {'answer': None, 'time': None, 'correct': False, 'score': 0}

    def generate_leaderboard(self):
        sorted_players = []
        for index, player_tuple_id_value in enumerate(sorted(self.players.items(), key=lambda player: player[1]['totalScore'], reverse=True), start=1):
            self.players[player_tuple_id_value[0]]['rank'] = index
            sorted_players.append(self.players[player_tuple_id_value[0]])
        return sorted_players, self.players

    def make_teams(self, number_of_teams):

        team_colors = ["Silver" ,"White" ,"Grey" ,"Black" ,"Navy" ,"Blue" ,"Cerulean" ,"Azure" ,"Turquoise" ,"Teal" ,"Cyan" ,"Green" ,"Lime" ,"Chartreuse" ,"Purlple" ,"Yellow" ,"Red" ,"Orange" ,"Indego" ,"Violet"]
        team_numbers = ["zero" ,"one" ,"two" ,"three" ,"four" ,"five" ,"six" ,"seven" ,"eight" ,"nine" ,"ten" ,"eleven" ,"twelve" ,"thirteen" ,"fourteen" ,"fifteen" ,"sixteen" ,"seventeen" ,"eighteen" ,"nineteen" ,"twenty" ,"twenty-one" ,"twenty-two" ,"twenty-three" ,"twenty-four" ,"twenty-five" ,"twenty-six" ,"twenty-seven" ,"twenty-eight" ,"twenty-nine" ,"thirty" ,"thirty-one" ,"thirty-two" ,"thirty-three" ,"thirty-four" ,"thirty-five" ,"thirty-six" ,"thirty-seven" ,"thirty-eight" ,"thirty-nine" ,"forty" ,"forty-one" ,"forty-two" ,"forty-three" ,"forty-four" ,"forty-five" ,"forty-six" ,"forty-seven" ,"forty-eight" ,"forty-nine" ,"fifty"]

        team_name_array = team_colors
        if random.randint(0,1) == 0:
            team_name_array = team_numbers

        team_names = random.sample(team_name_array, number_of_teams)
        players_per_team = floor(len(self.players)/number_of_teams)
        players_left = list(self.players.keys())

        # assign a group of players to each team
        for team in team_names:
            self.teams[team] = {'players': [], 'roundScore':0, 'totalScore': 0}
            team_players = random.sample(players_left, players_per_team)
            for player in team_players:
                self.teams[team]['players'].append(self.players[player]['name'])
                self.players[player]['team'] = team
                players_left.remove(player)

        # if the teams are uneven, add each left over player to a team
        for index, player in enumerate(players_left):
            self.players[player]['team'] = team_names[index]
            self.teams[team_names[index]]['players'].append(self.players[player]['name'])
        return self.teams


    def change_state(self, new_state):
        self.output = self.reset_output()
        if new_state is State.REGISTRATION:
            print('registration method')
            pass
        elif new_state is State.POST_REGISTRATION:
            print('post registration method')
            self.post_registration()
        elif new_state is State.MAKE_TEAMS:
            print('make teams method')
            if self.isTeam:
                self.output['host']['data'] = self.make_teams(self.number_of_teams)
                self.output['players']['data'] = self.players
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
            self.output['host']['data'], self.output['players']['data'] = self.get_results()
        else:
            print('passing')

        if self.output['host']['data'] or self.output['group']['data'] or self.output['players']['data']:
            return self.output
        return self.change_state(self.next_state())