from django.urls import path, include
from comms import views

app_name = 'comms'

urlpatterns = [
  path('pairings/<int:groupId>/', views.sendGroup, name='sendGroup'),
  path('pairings/<int:groupId>/<int:userId>/', views.sendUser, name='sendGroup')
]
