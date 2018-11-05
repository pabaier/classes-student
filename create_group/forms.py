from django import forms
from create_group.models import myCustomGroup


class newGroupForm(forms.ModelForm):
    class Meta():
        model = myCustomGroup
        fields = '__all__'
