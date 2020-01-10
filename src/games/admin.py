from django.contrib import admin

from .models import Game, Game_Question


class QuestionAdmin(admin.ModelAdmin):
    fields = ['text', 'a', 'b', 'c', 'd', 
				'answer', 'public', 'creator']

class GameAdmin(admin.ModelAdmin):
    fields = ['creator', 'name']

class GameQuestionAdmin(admin.ModelAdmin):
    fields = ['game', 'question', 'time_limit']

# admin.site.register(Question, QuestionAdmin)
# admin.site.register(Game, GameAdmin)
# admin.site.register(Game_Question, GameQuestionAdmin)

models = [Game, Game_Question]
for model in models:
	admin.site.register(model)