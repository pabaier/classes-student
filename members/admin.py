from django.contrib import admin
from django.contrib.auth import get_user_model
from django.contrib.auth.admin import UserAdmin
from members.models import User_By_Group

from .forms import MembersCreationForm, MembersChangeForm
from .models import Members

class MembersAdmin(UserAdmin):
    add_form = MembersCreationForm
    form = MembersChangeForm
    model = Members
    list_display = ['email', 'username','phone','name','address','exclusions']

admin.site.register(Members, MembersAdmin)
admin.site.register(User_By_Group)
