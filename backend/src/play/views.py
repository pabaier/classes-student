from django.shortcuts import render
from game.models import Game, ActiveGame

def index(request):
    return render(request, 'play/index.html', {})

def host(request, game_id):
    activeGame = ActiveGame(game_id=game_id)
    activeGame.save()

    return render(request, 'play/host.html', {
        'game_token': activeGame.slug
    })

def join(request, game_token):
    return render(request, 'play/join.html', {
        'game_token': game_token
    })