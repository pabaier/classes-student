from django.db import models
import datetime
# Create your models here.
class myCustomUsers(models.Model):
    user_name = models.CharField(max_length=128)
    user_email = models.EmailField(max_length=128)
    user_phone = models.CharField(max_length=128)
    user_address = models.CharField(max_length=128,null=True)
    user_exclusions = models.CharField(max_length=128,null=True)
    user_status = models.CharField(max_length=128,null=True)


class myCustomGroup(models.Model):
    group_name = models.CharField(max_length=128)
    end_date = models.DateField()
    members = models.ManyToManyField(myCustomUsers)
