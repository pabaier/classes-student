from django.contrib import admin
from django.urls import include, path
from quizpy.views import home_view, signup_view

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', home_view, name="home"),
    path('signup/', signup_view, name="signup"),
    path('game/', include('game.urls'))
]
