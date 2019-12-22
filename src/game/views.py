from django.shortcuts import render
from django.views.generic import ListView
from game.models import Question
from .forms import AddQuestionsForm

class QuestionList(ListView):
    model = Question

    form_class = AddQuestionsForm
    initial = {'key': 'value'}
    template_name = 'a.html'

    def get(self, request, *args, **kwargs):
        form = self.form_class()
        print(form)
        return render(request, self.template_name, {'form': form})

    def post(self, request, *args, **kwargs):
        form = self.form_class(request.POST)
        if form.is_valid():
            # <process form cleaned data>
            return HttpResponseRedirect('/success/')

        return render(request, self.template_name, {'form': form})