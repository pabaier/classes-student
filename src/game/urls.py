from django.urls import path
from game.views import QuestionList

urlpatterns = [
    path('questions/', QuestionList.as_view(template_name = 'a.html')),
]