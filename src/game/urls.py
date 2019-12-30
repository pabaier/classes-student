from django.urls import path
from . import views

urlpatterns = [
    path('questions/', views.QuestionList.as_view()),
    path('', views.GameList.as_view()),
    path('game/<int:pk>', views.GameDetail.as_view(), name='contact_detail'),
    path('create/', views.GameCreate.as_view(), name='game_create'),
    path('update/<int:pk>', views.GameUpdate.as_view(success_url="/game"), name='contact_update'),
]