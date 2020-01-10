from django.urls import include, path
from .views import QuestionViewSet
from rest_framework import routers

router = routers.DefaultRouter()
router.register('', QuestionViewSet, basename='QuestionViewSet')

urlpatterns = [
    path('', include(router.urls)),
]