from django.contrib import admin

from .models import Game, ActiveGame, Option, GameOption, Scoring


class GameAdmin(admin.ModelAdmin):
    fields = "__all__"


class ActiveGameAdmin(admin.ModelAdmin):
    fields = "__all__"


class OptionAdmin(admin.ModelAdmin):
    fields = "__all__"


class GameOptionAdmin(admin.ModelAdmin):
    fields = "__all__"


class ScoringAdmin(admin.ModelAdmin):
    fields = "__all__"

# admin.site.register(Question, QuestionAdmin)
# admin.site.register(Game, GameAdmin)
# admin.site.register(Game_Question, GameQuestionAdmin)


models = [Game, ActiveGame, Option, GameOption, Scoring]
for model in models:
    admin.site.register(model)
