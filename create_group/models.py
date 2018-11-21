from django.db import models
import datetime

class myGroups(models.Model):
    group_name = models.CharField(max_length=128)
    end_date = models.DateField(null=True)
    ship_date = models.DateField(null=True)
    created_by = models.CharField(max_length=128)
