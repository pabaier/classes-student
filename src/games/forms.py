from django import forms
from .models import Game
from question.models import Question

# class AddQuestionsForm(forms.ModelForm):

#     class Meta:
#         model = Question
#         fields = ['id', 'text']

#     def __init__(self, *args, **kwargs):
#         super().__init__(*args, **kwargs)
#         self.fields['members'] = forms.ModelMultipleChoiceField(
#             queryset = Question.objects.all(),
#             widget  = forms.CheckboxSelectMultiple(),
#         )

class AddQuestionsForm(forms.Form):
	choices = forms.ModelMultipleChoiceField(
		queryset = Question.objects.all(),
		widget  = forms.CheckboxSelectMultiple(),
	)
