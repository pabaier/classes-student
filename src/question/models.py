from django.db import models
from user.models import CustomUser

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
    category = models.CharField(max_length=30)
    creator = models.ForeignKey(CustomUser, on_delete=models.CASCADE)
