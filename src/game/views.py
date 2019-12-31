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

logger = logging.getLogger(__name__)

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

class GameDetail(DetailView):
    model = Game
class GameCreate(CreateView):
    template_name = 'game_create.html'
    fields = ['name']
    model = Game
class GameUpdate(UpdateView):
    template_name = 'game_update.html'
    fields = ['name']
    model = Game
class GameDelete(DeleteView):
    model = Game