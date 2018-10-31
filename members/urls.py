from django.urls import path, include
from .views import MembersView
from . import views

app_name = 'members'

urlpatterns = [
    path('', include('django.contrib.auth.urls')),
    path('signup/', MembersView.as_view(), name='signup'),
    path('profile/', views.profile, name='profile'),
    path('partners/', views.partners, name='partners'),
  #  path('changepassword/', view., name='change_password')

]