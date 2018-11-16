from django.shortcuts import render
from twilio.rest import Client
from members.models import Pairings, User_By_Group as userGroups
import os, json, sys

def sendText(user, pairing, number):
  with open(os.path.join(sys.path[0], 'secret_santa/config.json'), 'r') as f:
      config = json.load(f)
  tConfig = config['twilio']

  client = Client(tConfig['account_sid'], tConfig['auth_token'])
  txt = f'Hello {user}!\nYour pairing for Secret Santa is {pairing}!'
  
  try:
      message = client.messages.create(
          to    = f'{number}',
          from_ = tConfig['number'],
          body  = txt
      )
  except Exception as err:
      message = err.__dict__['msg']
  context = {"message": message}

def send(request):
  groupId = request.POST['groupId']
  pairings = Pairings.objects.filter(groupID=groupId)
  d = {}
  for pairs in pairings:
    user = pairs.member_1ID
    pair = pairs.member_2ID
    if(user.phone and user.phone != ''):
      d[user.id] = {'username':user.username, 'phone':user.phone, 'pairing':pair.username}
      sendText(user.username, pair.username, pair.phone)
    else:
      d[user.id] = {'username':user.username, 'email':user.email, 'pairing':pair.username}

  context = {'data': d}

  return render(request, 'comms/sent.html', context)

def test(request):
  return render(request, 'comms/testPost.html')
