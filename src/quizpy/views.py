from django.shortcuts import render
from django.contrib.auth import login, authenticate
from django.shortcuts import render, redirect
from users.forms import CustomUserCreationForm, JoinGameForm

def home_view(request):
	form = JoinGameForm(request.POST)
	if form.is_valid():
		print(form.cleaned_data.get('gameId'))
		# print(form.cleaned_data.get('value'))
	return render(request, 'home.html', {'form': form})

def signup_view(request):
	form = CustomUserCreationForm(request.POST)
	if form.is_valid():
		form.save()
		username = form.cleaned_data.get('username')
		password = form.cleaned_data.get('password1')
		user = authenticate(username=username, password=password)
		login(request, user)
		return redirect('home')
	return render(request, 'signup.html', {'form': form})