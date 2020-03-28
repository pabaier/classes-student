from django.contrib import admin

from .models import Question, QuestionGame, QuestionAnswerOption, QuestionHook


class QuestionAdmin(admin.ModelAdmin):
    fields = "__all__"


class QuestionGameAdmin(admin.ModelAdmin):
    fields = "__all__"


class QuestionAnswerOptionAdmin(admin.ModelAdmin):
    fields = "__all__"


class QuestionHookAdmin(admin.ModelAdmin):
    fields = "__all__"


models = [Question, QuestionGame, QuestionAnswerOption, QuestionHook]
for model in models:
    admin.site.register(model)
