from django.db import models
from users.models import CustomUser
from questions.models import Question
import random
from django.utils.crypto import get_random_string
from django.db import IntegrityError

class Game(models.Model):
    creator = models.ForeignKey(CustomUser, on_delete=models.CASCADE)
    name = models.CharField(max_length=30)

class Game_Question(models.Model):
    game = models.ForeignKey(Game, on_delete=models.CASCADE)
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    time_limit = models.IntegerField(default=15)

class Active_Game(models.Model):
    game = models.ForeignKey(Game, on_delete=models.CASCADE)
    slug = models.SlugField(max_length=7, unique=True)

    def save(self, *args, **kwargs):
        try:
            self.slug = get_random_string(7)
            super().save(*args, **kwargs)
        except IntegrityError:
            self.save(*args, **kwargs)
