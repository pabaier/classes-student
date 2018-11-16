from django.urls import path, include
from comms import views

app_name = 'comms'

urlpatterns = [
  path('', views.send, name='send'),
  path('test', views.test, name='test')
]
