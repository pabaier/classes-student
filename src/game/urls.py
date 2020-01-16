from django.urls import include, path
from .views import GameViewSet, GameDetailViewSet
from rest_framework import routers

router = routers.DefaultRouter()
router.register(r'details', GameDetailViewSet, basename='GameDetailViewSet')
router.register('', GameViewSet, basename='GameViewSet')

urlpatterns = [
    path('', include(router.urls)),
]