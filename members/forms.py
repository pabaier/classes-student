from django import forms
from django.contrib.auth.forms import UserCreationForm, UserChangeForm
from members.models import Members

class MembersCreationForm(UserCreationForm):

    class Meta(UserCreationForm.Meta):
        model = Members
        fields = ('username', 'email', 'phone', 'first_name', 'last_name', 'address', 'city', 'state', 'zip_code')

class MembersChangeForm(UserChangeForm):

    class Meta:
        model = Members
        fields = ('username',)

class newMembersForm(forms.ModelForm):

    class Meta():
        model = Members
        exclude = '__all__'
