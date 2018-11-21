from members.forms import MembersCreationForm
from django.shortcuts import render
from django.urls import reverse_lazy
from django.views import generic
from members.models import Members

class MembersView(generic.CreateView):
    form_class = MembersCreationForm
    success_url = reverse_lazy('home')
    template_name = 'signup.html'

def profile(request):
  if request.user.id:
    result = Members.objects.get(id=request.user.id)
    print(result.first_name)
    result = {
      'username': result.username,
      'phone': result.phone,
      'firstname': result.first_name,
      'lastname': result.last_name,
      'email': result.email
    }
  return render(request, 'profile.html', {'result': result})

def partners(request):
  return render(request, 'partners.html')

def login(request):
    return render(request, 'login.html')

def update(request, userId):
  return render(request, 'profile.html', {'result': result})
  
