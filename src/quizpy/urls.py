from django.contrib import admin
from django.urls import include, path, re_path
from rest_framework_jwt.views import obtain_jwt_token, refresh_jwt_token, verify_jwt_token

urlpatterns = [
    path('games/', include('game.urls')),
    path('questions/', include('question.urls')),
    path('users/', include('user.urls')),
    path('admin/', admin.site.urls),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    path('auth/jwt-auth/', obtain_jwt_token),
    path('auth/api-token-refresh/', refresh_jwt_token),
    path('auth/api-token-verify/', verify_jwt_token),
]
