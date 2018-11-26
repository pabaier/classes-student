from django.urls import path, include
from create_group import views

app_name = 'create_group'

urlpatterns = [
  path('creategroup/', views.form_view, name='creategroup'),
  path('dashboard/', views.show_groups, name='dashboard'),
  path('joingroup/',views.join_group, name='joingroup'),
  path('editgroup/<int:groupID>/', views.edit_group, name='editgroup'),
  path('<int:groupId>/pair', views.make_pairs, name='pair'),
  path('', views.show_groups, name='myGroups')
]
