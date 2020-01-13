from django.urls import include, path
from .views import QuestionViewSet, QuestionGameViewSet, QuestionAnswerOptionViewSet, QuestionDetailViewSet
from rest_framework import routers

router = routers.DefaultRouter()
router.register(r'game', QuestionGameViewSet, basename='QuestionGameViewSet')
router.register(r'answers', QuestionAnswerOptionViewSet, basename='QuestionAnswerOptionViewSet')
router.register(r'details', QuestionDetailViewSet, basename='QuestionDetailViewSet')
router.register('', QuestionViewSet, basename='QuestionViewSet')

urlpatterns = [
    path('', include(router.urls)),
]