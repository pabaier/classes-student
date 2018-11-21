from members.forms import MembersCreationForm
from django.shortcuts import render
from django.http import JsonResponse
from django.urls import reverse_lazy
from django.views import generic
from members.models import Members
from django.views.decorators.csrf import csrf_exempt
import json

class MembersView(generic.CreateView):
    form_class = MembersCreationForm
    success_url = reverse_lazy('home')
    template_name = 'signup.html'

def profile(request):
  if request.user.id:
    result = Members.objects.get(id=request.user.id)
    for e in Members._meta.get_fields():
      print(e)
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

@csrf_exempt
def update(request, userId):
  body_unicode = request.body.decode('utf-8')
  body = json.loads(body_unicode)
  try:
    Members.objects.filter(id=userId).update(
      email=body['email'], 
      phone=body['phone'],
      username=body['username'],
      first_name=body['firstname'],
      last_name=body['lastname']
      )
    return JsonResponse({"success": True})
  except:
    return JsonResponse({"success": False})
  
