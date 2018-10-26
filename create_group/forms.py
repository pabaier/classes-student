from django import forms
from create_group.models import myCustomGroup,myCustomUsers


class newGroupForm(forms.ModelForm):
    class Meta():
        model = myCustomGroup
        fields = '__all__'

class newUsersForm(forms.ModelForm):
    class Meta():
        model = myCustomUsers
        exclude = '__all__'
