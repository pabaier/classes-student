from django.shortcuts import render
from django.http import JsonResponse
from django.conf import settings
from django.core.mail import send_mail
from twilio.rest import Client
from members.models import Members, Pairings, User_By_Group as userGroups
from create_group.models import myGroups
import os, json, sys

def sendText(phoneNumber, text):
  with open(os.path.join(sys.path[0], 'secret_santa/config.json'), 'r') as f:
      config = json.load(f)
  tConfig = config['twilio']

  client = Client(tConfig['account_sid'], tConfig['auth_token'])

  try:
    message = client.messages.create(
      to    = f'{phoneNumber}',
      from_ = tConfig['number'],
      body  = text
    )
    result = {'success': True}
  except Exception as err:
    message = err.__dict__['msg']
    result = {'success': False, 'message': message}
  return result

def sendEmail(userEmail, emailSubject, emailMessage):
  subject =  emailSubject
  message = emailMessage
  toEmail = [userEmail]
  try:
    send_mail(subject, message, settings.EMAIL_HOST_USER, toEmail, fail_silently=False,)
    result = {'success': True}
  except Exception as err:
    message = 'Could not send email'
    result = {'success': False, 'message': message}
  return result

def sendGroup(request, groupId):
  if (not userGroups.objects.filter(member_1ID=request.user.id, group_ID=groupId).exists()):
    return JsonResponse({'failure': [{
        'userName': request.user.username,
        'userId': request.user.id,
        'groupName': '',
        'groupId': groupId,
      'message': 'You are not part of the requested group'
    }]})
  pairings = Pairings.objects.filter(groupID=groupId)
  groupName = myGroups.objects.get(id=groupId).group_name
  results = {'success': [], 'failure': []}
  for pairs in pairings:
    user = pairs.member_1ID
    pair = pairs.member_2ID
    if(user.phone):
      txt = f'Hello {user.username}!\nYour Secret Santa pairing for group {groupName} is {pair.username}!'
      result = sendText(user.phone, txt)
      if(not result['success']):
        message = f'Hello {user.username}!\nYour Secret Santa pairing for group {groupName} is {pair.username}!'
        subject = f'Secret Santa Pairing For Group {groupName}'
        result = sendEmail(user.email, subject, message)
    else:
      message = f'Hello {user.username}!\nYour Secret Santa pairing for group {groupName} is {pair.username}!'
      subject = f'Secret Santa Pairing For Group {groupName}'
      result = sendEmail(user.email, subject, message)
    if (result['success']):
      results['success'].append({
        'userName': user.username,
        'userId': user.id,
        'groupName': groupName,
        'groupId': groupId,
        'message': f"Success contacting {user.username}",
        })
    else:
      results['failure'].append({
        'userName': user.username,
        'userId': user.id,
        'groupName': groupName,
        'groupId': groupId,
        'message': f"Failed contacting {user.username} - {result['message']}",
        })
  
  # output = {k:v for (k,v) in results.items() if len(results[k]) > 0}
  return JsonResponse(results)

def sendUser(request, groupId, userId):
  if (not userGroups.objects.filter(member_1ID=request.user.id, group_ID=groupId).exists()):
    return JsonResponse({'failure': {
      'userName': request.user.username,
      'userId': request.user.id,
      'groupName': '',
      'groupId': groupId,
      'message': 'You are not part of the requested group'
      }})
  userPairing = Pairings.objects.get(groupID=groupId, member_1ID=userId)
  groupName = myGroups.objects.get(id=groupId).group_name
  results = {}
  user = userPairing.member_1ID
  pair = userPairing.member_2ID
  if(user.phone):
    txt = f'Hello {user.username}!\nYour Secret Santa pairing for group {groupName} is {pair.username}!'
    result = sendText(user.phone, txt)
    if(not result['success']):
      message = f'Hello {user.username}!\nYour Secret Santa pairing for group {groupName} is {pair.username}!'
      subject = f'Secret Santa Pairing For Group {groupName}'
      result = sendEmail(user.email, subject, message)
  else:
    message = f'Hello {user.username}!\nYour Secret Santa pairing for group {groupName} is {pair.username}!'
    subject = f'Secret Santa Pairing For Group {groupName}'
    result = sendEmail(user.email, subject, message)
  if (result['success']):
    results['success'] = {
      'userName': user.username,
      'userId': userId,
      'groupName': groupName,
      'groupId': groupId,
      'message': f"Success contacting {user.username}"
    }
  else:
    results['failure'] = {
      'userName': user.username,
      'userId': userId,
      'groupName': groupName,
      'groupId': groupId,
      'message': f"Failed contacting {user.username} - {result['message']}"
    }
  return JsonResponse(results)

def newUser(request, userId):
  user = Members.objects.get(id=userId)
  txt = f'Hello {user.username}!\nYou were signed up for Secret Santa! To login, visit SecretSanta. Your username is {user.username} and you password is "SecretSanta1"'
  if(user.phone):
    result = sendText(user.phone, txt)
    if(not result['success']):
      subject = f'Secret Santa!'
      result = sendEmail(user.email, subject, txt)
  else:
    subject = f'Secret Santa!'
    result = sendEmail(user.email, subject, txt)
  return JsonResponse({'success': True})
