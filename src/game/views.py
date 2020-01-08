from django.shortcuts import render
from django.views.generic import ListView, View
from game.models import Question, Game, Game_Question
from .forms import AddQuestionsForm
from django.http import HttpResponse, QueryDict
from users.models import CustomUser
import json
import logging
from django.views.generic import ListView, DetailView 
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.core import serializers
from django.forms.models import model_to_dict

from game.models import Question, Game, Game_Question, Active_Game
from rest_framework import viewsets, generics
from game.serializers import QuestionSerializer


logger = logging.getLogger(__name__)

# class QuestionViewSet(viewsets.ModelViewSet):
#     """
#     API endpoint that allows questions to be viewed or edited.
#     """
#     queryset = Question.objects.all()
#     serializer_class = QuestionSerializer

class QuestionViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows questions to be viewed or edited.
    """
    serializer_class = QuestionSerializer

    def get_queryset(self):
        user = self.request.user
        return Question.objects.filter(creator_user_id=user)


class QuestionList(ListView):
    model = Question

    form_class = AddQuestionsForm
    initial = {'key': 'value'}
    template_name = 'a.html'

    def get(self, request, *args, **kwargs):
        form = self.form_class()
        return render(request, self.template_name, {'form': form})

    def post(self, request, *args, **kwargs):
        # request.POST = {'csrfmiddlewaretoken':#, 'name':'hi-ho', selected:"{'id':1, 'time':15},..."}
        selected = json.loads(request.POST['selected'])
        name = request.POST['gameName']
        game = Game.objects.create(name=name, creator_user_id=request.user)
        game.save()
        logger.info(f'game saved: {game.name} with id {game.id}')
        logger.info(f'adding {len(selected)} questions to game')
        for selection in selected:
            question = Question.objects.get(id=selection['id'])
            game_question = Game_Question.objects.create(
                game_id=game, 
                question_id=question,
                time_limit=selection['time']
            )

        return HttpResponse(json.dumps({'key': 'value'}))
        # return render(request, self.template_name, {'form': form})

class GameList(View):
    template_name = 'MyGames.html'
    # queryset = Game.objects.get(creator_user_id=request.user.id)
    queryset = Game.objects.all()
    context_object_name = 'games'

    def get(self, request, *args, **kwargs):
        games = Game.objects.filter(creator_user_id=request.user)
        data = {}
        for game in games:
            data[game.id] = game.name
        return render(request, self.template_name, {'data': data})

    def delete(self, request, *args, **kwargs):
        data = QueryDict(request.body)
        logger.info(f'deleting game {data["id"]}')
        Game.objects.filter(id=data["id"]).delete()
        return HttpResponse(json.dumps({'key': 'value'}))

    def post(self, request, *args, **kwargs):
        name = request.POST['name']
        logger.info(f'name: {name}')
        newGame = Game.objects.create(
            creator_user_id = request.user,
            name = name
        )
        newGame.save()
        return HttpResponse(json.dumps({'name': name, 'id': newGame.id}))

class GameEdit(UpdateView):
    template_name = 'EditGame.html'
    fields = ['name']
    model = Game

    def get(self, request, *args, **kwargs):
        gameId = kwargs['id']
        game = Game.objects.get(id=gameId)
        gameName = game.name

        gameQuestions = self.getGameQuestions(gameId, gameName)
        userQuestions = self.getUserQuestions(request.user)
        data = {
            'gameId':gameId, 
            'gameName': gameName, 
            'gameQuestions': gameQuestions,
            'userQuestions': userQuestions
        }
        # for game in games:
        #     data[game.id] = game.name
        return render(request, self.template_name, {'data': data})
    
    def post(self, request, *args, **kwargs):
        logger.info(f'received {request.POST}')
        id = request.POST['id']
        newName = request.POST['name']
        Game.objects.filter(id=id).update(name=newName)
        return HttpResponse(json.dumps({'newName': newName}))

    def put(self, request, *args, **kwargs):
        gameId = kwargs['id']
        data = QueryDict(request.body)
        questionId = data['questionId']
        newValue = data['newValue']
        gameQuestionObject = Game_Question.objects.get(game_id=gameId, question_id=questionId)
        gameQuestionObject.time_limit = newValue
        gameQuestionObject.save(update_fields=['time_limit'])
        return HttpResponse(json.dumps({'success': True}))


    @staticmethod
    def getGameQuestions(gameId, gameName):
        questionIdObjects = Game_Question.objects.filter(game_id=gameId)
        questions = []
        for q in questionIdObjects:
            question = Question.objects.get(id=q.question_id.id)
            questionDict = model_to_dict(question)
            questionDict['time'] = q.time_limit
            questions.append(questionDict)
        return questions

    @staticmethod
    def getUserQuestions(user):
        questionsObjects = Question.objects.filter(creator_user_id = user)
        questions = []
        for q in questionsObjects:
            qd = model_to_dict(q)
            questions.append(qd)
        # j = serializers.serialize("json", questions)
        return questions

class GameDetail(DetailView):
    model = Game
class GameCreate(CreateView):
    template_name = 'game_create.html'
    fields = ['name']
    model = Game
class GameDelete(DeleteView):
    model = Game