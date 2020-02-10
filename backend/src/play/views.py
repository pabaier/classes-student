from django.shortcuts import render
from random import randint

def index(request):
    return render(request, 'play/index.html', {})

def host(request):
    return render(request, 'play/host.html', {
        'game_token': randint(1,10)
    })

def join(request, game_token):
    return render(request, 'play/join.html', {
        'game_token': game_token
    })