from members.forms import MembersCreationForm
from django.shortcuts import render, redirect
from django.http import JsonResponse
from django.urls import reverse_lazy
from django.views import generic
from members.models import Members, Pairings
from django.views.decorators.csrf import csrf_exempt
from django.forms.models import model_to_dict
import json
import re

class MembersView(generic.CreateView):
    form_class = MembersCreationForm
    success_url = reverse_lazy('home')
    template_name = 'signup.html'

def profile(request):
  if request.user.is_authenticated:
    if request.user.id:
      result = Members.objects.get(id=request.user.id)
      resultDict = model_to_dict(result)
      for key, value in resultDict.items():
        if value is None:
          resultDict[key] = ""
      result = {
        'username': resultDict['username'],
        'phone': resultDict['phone'],
        'firstname': resultDict['first_name'],
        'lastname': resultDict['last_name'],
        'email': resultDict['email'],
        'address': resultDict['address'],
        'city': resultDict['city'],
        'state': resultDict['state'],
        'zip': resultDict['zip_code']
      }
    return render(request, 'profile.html', {'result': result})
  else:
    return redirect('members:signup')


def partners(request):
  if request.user.is_authenticated:
    return render(request, 'partners.html')
  else:
    return redirect('members:signup')

def pairings(request, userId):
  pairingData = Pairings.objects.filter(id=userId)
  if len(pairingData)>0:
    userProfileDict = model_to_dict(pairingData[0].member_1ID)
    userProfileDict.pop('password', None)
    response = {'currentUser': userProfileDict, 'pairings':[]}
    for pairingRecord in pairingData:
      response['pairings'].append({'group': model_to_dict(pairingRecord.groupID), 'pairing': model_to_dict(pairingRecord.member_2ID)})
    print(json.dumps(response, default=str, indent=2))
    return JsonResponse({'success': True, 'response': json.dumps(response, default=str)})
  return JsonResponse({'success': False})


def login(request):
  return render(request, 'login.html')

@csrf_exempt
def update(request, userId):
  body_unicode = request.body.decode('utf-8')
  body = json.loads(body_unicode)
  for key in body.keys():
    if body[key] == '':
      body[key] = None
  try:
    Members.objects.filter(id=userId).update(
      email=body['email'], 
      phone=body['phone'],
      username=body['username'],
      first_name=body['firstname'],
      last_name=body['lastname'],
      address=body['address'],
      city=body['city'],
      state=body['state'],
      zip_code=body['zip']
    )
    return JsonResponse({"success": True})
  except Exception as e:
    message = re.sub(r'members_members\.','',str(e))
    return JsonResponse({"success": False, "message": message})
  
