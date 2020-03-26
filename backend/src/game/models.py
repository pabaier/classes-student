from django.db import models
from django.utils.crypto import get_random_string
from django.db import IntegrityError
from user.models import CustomUser
from question.models import Question


class Scoring(models.Model):
    hook = models.TextField(blank=True)

class PostRegistrationHook(models.Model):
    hook = models.TextField(blank=True)

class Game(models.Model):
    creator = models.ForeignKey(CustomUser, on_delete=models.CASCADE)
    name = models.CharField(max_length=30)
    questions = models.ManyToManyField(Question, through='question.QuestionGame')
    scoring = models.ForeignKey(Scoring, related_name='game_scoring', on_delete=models.CASCADE, blank=True, null=True)
    post_registration_hook = models.ForeignKey(PostRegistrationHook, related_name='game_post_registration_hook', on_delete=models.CASCADE, blank=True, null=True)

class ActiveGame(models.Model):
    game = models.ForeignKey(Game, on_delete=models.CASCADE)
    slug = models.SlugField(max_length=7, unique=True)

    def save(self, *args, **kwargs):
        try:
            self.slug = get_random_string(7)
            super().save(*args, **kwargs)
        except IntegrityError:
            self.save(*args, **kwargs)


class Option(models.Model):
    type = models.CharField(max_length=20, unique=True)


class GameOption(models.Model):
    game = models.ForeignKey(Game, on_delete=models.CASCADE)
    option = models.ForeignKey(Option, on_delete=models.CASCADE)

    class Meta:
        unique_together = ('game', 'option',)
