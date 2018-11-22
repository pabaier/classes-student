from django.urls import path, include
from .views import MembersView
from . import views

app_name = 'members'

urlpatterns = [
    path('', include('django.contrib.auth.urls')),
    path('signup/', MembersView.as_view(), name='signup'),
    path('profile/', views.profile, name='profile'),
    path('pairings/<int:userId>', views.pairings, name='pairings'),
    path('partners/', views.partners, name='partners'),
    path('login/', views.login, name='login'),
    path('update/<int:userId>', views.update, name='update')
  #  path('changepassword/', view., name='change_password')
]
