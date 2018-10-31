import uuid
from django.db import models
import datetime
# Create your models here.


class myGroups(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4())
    group_name = models.CharField(max_length=128)
    end_date = models.DateField(null=True)
    ship_date = models.DateField(null=True)
    created_by = models.CharField(max_length=128)







