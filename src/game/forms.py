from django import forms
from .models import Question

class AddQuestionsForm(forms.Form):
	choices = forms.ModelMultipleChoiceField(
		queryset = Question.objects.all(),
		widget  = forms.CheckboxSelectMultiple(),
	)
