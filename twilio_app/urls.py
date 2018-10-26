from django.urls import path
from . import views

app_name = 'twilio_app'

urlpatterns = [
    path('text/', views.send, name='send'),
]