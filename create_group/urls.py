from django.conf.urls import url
from create_group import views


urlpatterns = [

    url(r'^$', views.show_myGroups,name = 'myGroups')
]
