from django.contrib import admin

from .models import Question


class QuestionAdmin(admin.ModelAdmin):
    fields = ['text', 'a', 'b', 'c', 'd', 
				'answer', 'public', 'creator_user_id']

admin.site.register(Question, QuestionAdmin)