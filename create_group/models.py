from django.db import models
import datetime
# Create your models here.


class myCustomGroup(models.Model):
    group_name = models.CharField(max_length=128)
    end_date = models.DateField()
