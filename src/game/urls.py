from django.urls import include, path
from .views import GameViewSet
from rest_framework import routers

router = routers.DefaultRouter()
router.register('', GameViewSet, basename='GameViewSet')

urlpatterns = [
    path('', include(router.urls)),
]