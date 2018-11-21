from create_group.models import myGroups
from django.db import models
from django.contrib.auth.models import AbstractUser


# Create your models here.
class Members(AbstractUser):
#    name = models.CharField(max_length=30, blank=True, null=True)
    street = models.CharField(max_length=30, blank=True, null=True)
    state = models.CharField(max_length=2, blank=True, null=True)
    zip_code = models.CharField(max_length=5, blank=True, null=True)
    address = models.CharField(max_length=30, blank=True, null=True)
    phone = models.CharField(max_length=10, blank=True, null=True)
    exclusions = models.CharField(max_length=30, blank=True, null=True)


    def __str__(self):
        return self.username

# https://stackoverflow.com/a/36916782
class Pairings(models.Model):
    member_1ID = models.ForeignKey('Members', related_name='member_1', on_delete=models.CASCADE)
    member_2ID = models.ForeignKey('Members', related_name='member_2', on_delete=models.CASCADE)
    groupID = models.ForeignKey('create_group.myGroups', on_delete=models.CASCADE)

    def __str__(self):
        return f'{self.member_1ID}, {self.member_2ID}, {self.groupID}'


class User_By_Group(models.Model):
    member_1ID = models.ForeignKey('Members', on_delete=models.CASCADE)
    group_ID = models.ForeignKey('create_group.myGroups', on_delete=models.CASCADE)


class Wishlist(models.Model):
    ubg_ID = models.ForeignKey('User_By_Group', on_delete=models.CASCADE)
    item_name = models.CharField(max_length=128)
