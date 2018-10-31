from django.urls import path, include
from create_group import views

app_name = 'create_group'

urlpatterns = [
  path('creategroup/', views.form_view, name='creategroup'),
  path('dashboard/', views.show_groups, name='dashboard'),
  path('', views.show_groups, name='myGroups')
]
