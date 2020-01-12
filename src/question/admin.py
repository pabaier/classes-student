from django.contrib import admin

from .models import Question, Question_Game, Question_Answer_Option

class QuestionAdmin(admin.ModelAdmin):
    fields = "__all__"

class QuestionGameAdmin(admin.ModelAdmin):
    fields = "__all__"

class QuestionAnswerOptionAdmin(admin.ModelAdmin):
    fields = "__all__"

models = [Question, Question_Game, Question_Answer_Option]
for model in models:
	admin.site.register(model)