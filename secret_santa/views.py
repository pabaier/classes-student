from django.shortcuts import render

def home(request):
    context = {'subtitle': '<h2>A Fun Gift Exchange!</h2>'}
    return render(request, 'home.html', context)