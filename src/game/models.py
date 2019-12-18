from django.db import models
from users.models import CustomUser
import random
from django.utils.crypto import get_random_string
from django.db import IntegrityError

class Question(models.Model):
    ANSWER_CHOICES = [
        ('a', 'A'),
        ('b', 'B'),
        ('c', 'C'),
        ('d', 'D'),
    ]

    text = models.CharField(max_length=30)
    a = models.CharField(max_length=30)
    b = models.CharField(max_length=30)
    c = models.CharField(max_length=30)
    d = models.CharField(max_length=30)
    answer = models.CharField(max_length=1, choices=ANSWER_CHOICES)
    public = models.BooleanField(default=False)
    creator_user_id = models.ForeignKey(CustomUser, on_delete=models.CASCADE)

class Game(models.Model):
    creator_user_id = models.ForeignKey(CustomUser, on_delete=models.CASCADE)

class Game_Question(models.Model):
    game_id = models.ForeignKey(Game, on_delete=models.CASCADE)
    question_id = models.ForeignKey(Question, on_delete=models.CASCADE)
    time_limit = models.IntegerField(default=15)

class Active_Game(models.Model):
    game_id = models.ForeignKey(Game, on_delete=models.CASCADE)
    slug = models.SlugField(max_length=7, unique=True)

    def save(self, *args, **kwargs):
        try:
            self.slug = get_random_string(7)
            super().save(*args, **kwargs)
        except IntegrityError:
            self.save(*args, **kwargs)
