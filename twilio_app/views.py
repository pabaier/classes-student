from django.shortcuts import render
from twilio.rest import Client
import os, json, sys

def send(request):
    with open(os.path.join(sys.path[0], 'secret_santa/config.json'), 'r') as f:
        config = json.load(f)
    tConfig = config['twilio']

    client = Client(tConfig['account_sid'], tConfig['auth_token'])
    mess = "hey hey hey"
    message = client.messages.create(
        to    = "", # add number from request post
        from_ = tConfig['number'],
        body  = mess
    )
    context = {"message": message}

    return render(request, 'sent.html', context)