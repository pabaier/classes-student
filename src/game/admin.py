from django.contrib import admin

from .models import Question, Game, Game_Question


class QuestionAdmin(admin.ModelAdmin):
    fields = ['text', 'a', 'b', 'c', 'd', 
				'answer', 'public', 'creator_user_id']

class GameAdmin(admin.ModelAdmin):
    fields = ['creator_user_id', 'name']

class GameQuestionAdmin(admin.ModelAdmin):
    fields = ['game_id', 'question_id', 'time_limit']

# admin.site.register(Question, QuestionAdmin)
# admin.site.register(Game, GameAdmin)
# admin.site.register(Game_Question, GameQuestionAdmin)

models = [Question, Game, Game_Question]
for model in models:
	admin.site.register(model)