from django.contrib import admin
from django.urls import include, path
from .views import home_view, signup_view

urlpatterns = [
    path('games/', include('game.urls')),
    path('questions/', include('question.urls')),
    path('admin/', admin.site.urls),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
    # path('', home_view, name="home"),
    # path('signup/', signup_view, name="signup"),
]
