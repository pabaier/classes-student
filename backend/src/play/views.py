from django.shortcuts import render

def index(request):
    return render(request, 'play/index.html', {})

def host(request, game_token):
    return render(request, 'play/host.html', {
        'game_token': game_token
    })

def join(request, game_token):
    return render(request, 'play/join.html', {
        'game_token': game_token
    })