from django.db import models
from user.models import CustomUser
from game.models import Game


class Question(models.Model):
    text = models.CharField(max_length=30)
    public = models.BooleanField(default=False)
    category = models.CharField(max_length=30)
    creator = models.ForeignKey(CustomUser, on_delete=models.CASCADE)


class QuestionGame(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    game = models.ForeignKey(Game, on_delete=models.CASCADE)
    time_limit = models.IntegerField(default=15)


class QuestionAnswerOption(models.Model):
    question = models.ForeignKey(Question, related_name='answerOptions', on_delete=models.CASCADE)
    option = models.CharField(max_length=256)
    isAnswer = models.BooleanField()
