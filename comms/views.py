from django.shortcuts import render
from django.conf import settings
from django.core.mail import send_mail
from twilio.rest import Client
from members.models import Pairings, User_By_Group as userGroups
from create_group.models import myGroups
import os, json, sys

def sendText(userName, pairingName, groupName, userPhoneNumber):
  with open(os.path.join(sys.path[0], 'secret_santa/config.json'), 'r') as f:
      config = json.load(f)
  tConfig = config['twilio']

  client = Client(tConfig['account_sid'], tConfig['auth_token'])
  txt = f'Hello {userName}!\nYour Secret Santa pairing for group {groupName} is {pairingName}!'
  
  try:
      message = client.messages.create(
          to    = f'{userPhoneNumber}',
          from_ = tConfig['number'],
          body  = txt
      )
  except Exception as err:
      message = err.__dict__['msg']
  context = {"message": message}

def sendEmail(userName, pairingName, groupName, userEmail):
  subject =  f'Secret Santa Pairing For Group {groupName}'
  message = f'Hello {userName}!\nYour Secret Santa pairing for group {groupName} is {pairingName}!'
  toEmail = [userEmail]
  send_mail(subject, message, settings.EMAIL_HOST_USER, toEmail, fail_silently=False,)

def send(request):
  groupId = request.POST['groupId']
  pairings = Pairings.objects.filter(groupID=groupId)
  groupName = myGroups.objects.filter(id=groupId)[0].group_name
  d = {}
  for pairs in pairings:
    user = pairs.member_1ID
    pair = pairs.member_2ID
    if(user.phone and user.phone != ''):
      d[user.id] = {'username':user.username, 'phone':user.phone, 'pairing':pair.username}
      sendText(user.username, pair.username, groupName, user.phone)
    else:
      d[user.id] = {'username':user.username, 'email':user.email, 'pairing':pair.username}
      sendEmail(user.username, pair.username, groupName, user.email)

  context = {'data': d}

  return render(request, 'comms/sent.html', context)

def test(request):
  return render(request, 'comms/testPost.html')
