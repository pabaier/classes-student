from django import forms
from create_group.models import myGroups
from members.models import Members

class newGroupForm(forms.ModelForm):
    class Meta():
        model = myGroups
        fields = '__all__'

class PostForm(forms.ModelForm):
    class Meta:
        model = myGroups
        fields = '__all__'
