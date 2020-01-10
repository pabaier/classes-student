from django.contrib import admin

from .models import Question

class QuestionAdmin(admin.ModelAdmin):
    fields = ['text', 'a', 'b', 'c', 'd', 
				'answer', 'public', 'creator']

models = [Question]
for model in models:
	admin.site.register(model)