from django.contrib import admin

from .models import Game, Game_Question, Active_Game, Option, Game_Option


class QuestionAdmin(admin.ModelAdmin):
    fields = "__all__"

class GameAdmin(admin.ModelAdmin):
    fields = "__all__"

class GameQuestionAdmin(admin.ModelAdmin):
    fields = "__all__"

class ActiveGame(admin.ModelAdmin):
    fields = "__all__"

class OptionAdmin(admin.ModelAdmin):
    fields = "__all__"

class GameOptionAdmin(admin.ModelAdmin):
    fields = "__all__"

# admin.site.register(Question, QuestionAdmin)
# admin.site.register(Game, GameAdmin)
# admin.site.register(Game_Question, GameQuestionAdmin)

models = [Game, Game_Question, Active_Game, Option, Game_Option]
for model in models:
	admin.site.register(model)