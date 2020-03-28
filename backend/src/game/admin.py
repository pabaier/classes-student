from django.contrib import admin

from .models import Game, ActiveGame, Option, GameOption, ScoringHook, GameHook


class GameAdmin(admin.ModelAdmin):
    fields = "__all__"


class ActiveGameAdmin(admin.ModelAdmin):
    fields = "__all__"


class OptionAdmin(admin.ModelAdmin):
    fields = "__all__"


class GameOptionAdmin(admin.ModelAdmin):
    fields = "__all__"


class ScoringHookAdmin(admin.ModelAdmin):
    fields = "__all__"

class GameHookAdmin(admin.ModelAdmin):
    fields = "__all__"

# admin.site.register(Question, QuestionAdmin)
# admin.site.register(Game, GameAdmin)
# admin.site.register(Game_Question, GameQuestionAdmin)


models = [Game, ActiveGame, Option, GameOption, ScoringHook, GameHook]
for model in models:
    admin.site.register(model)
