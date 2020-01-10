from django.contrib import admin
from django.urls import include, path
from quizpy.views import home_view, signup_view

from rest_framework import routers
from quizpy import views

router = routers.DefaultRouter()
router.register(r'users', views.UserViewSet)
router.register(r'groups', views.GroupViewSet)

urlpatterns = [
    # path('games/', include('games.urls')),
    path('questions/', include('questions.urls')),
    path('admin/', admin.site.urls),
    path('', home_view, name="home"),
    path('signup/', signup_view, name="signup"),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]
