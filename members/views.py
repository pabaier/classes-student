from members.forms import MembersCreationForm
from django.shortcuts import render, redirect
from django.http import JsonResponse, HttpResponseRedirect
from django.urls import reverse_lazy
from django.views import generic
from members.models import Members, Pairings, User_By_Group
from django.views.decorators.csrf import csrf_exempt
from django.forms.models import model_to_dict
from django.contrib.auth import authenticate, login as auth_login
import json
import re

class MembersView(generic.CreateView):
    form_class = MembersCreationForm
    success_url = reverse_lazy('create_group:dashboard')
    template_name = 'signup.html'

    def form_valid(self, form):  
        valid = super().form_valid(form)
        username, password = form.cleaned_data.get('username'), form.cleaned_data.get('password1')
        user = authenticate(username=username, password=password)
        auth_login(self.request, user)
        return HttpResponseRedirect("/groups/dashboard")

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
    return JsonResponse({'success': True, 'response': json.dumps(response, default=str)})
  return JsonResponse({'success': False})

def usersInSameGroup(user1ID, user2ID):
    usersGroups = User_By_Group.objects.filter(member_1ID=user1ID)
    requestedUsersGroups = User_By_Group.objects.filter(member_1ID=user2ID)
    sameGroups = []
    for a in usersGroups:
      for b in requestedUsersGroups:
        if a.group_ID == b.group_ID:
          sameGroups.append(a.group_ID)
    return sameGroups

def exclusions(request, userId):
  if request.user.is_authenticated:
    sameGroups = usersInSameGroup(request.user.id, userId)
    if len(sameGroups) > 0:
      requestedMember = model_to_dict(Members.objects.get(id=userId))
      groupMembers = []
      for group in sameGroups:
        grp = {'id': group.id, 'name': group.group_name, 'members': []}
        ubg = User_By_Group.objects.filter(group_ID=group.id)
        for member in ubg:
          m = member.member_1ID
          if not m.id == requestedMember['id']:
            grp['members'].append({
              'id': m.id,
              'firstName': m.first_name,
              'lastname': m.last_name,
              'username': m.username
            })
        groupMembers.append(grp)
        
      # a = model_to_dict(sameGroups[0])
      # print(json.dumps(groupMembers, indent=2, default=str))
      data = {'success': True, 'data': groupMembers, 'requested': requestedMember}
    else:
      data = {'success': False, 'message': 'Sorry, you are not in any groups with the requested member'}
    return render(request, 'exclusions.html', context=data)
  return render(request, 'members:signup')

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
  
