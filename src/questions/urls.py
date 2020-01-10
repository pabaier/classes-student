from django.urls import include, path
from . import views
from rest_framework import routers

router = routers.DefaultRouter()
router.register('', views.QuestionsViewSet, basename='QuestionsViewSet')
router.register('<int:pk>', views.QuestionViewSet), basename='QuestionViewSet')

urlpatterns = [
    path('', include(router.urls)),
]