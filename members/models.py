import uuid
from create_group.models import myGroups
from django.db import models
from django.contrib.auth.models import AbstractUser


# Create your models here.
class Members(AbstractUser):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4())
    street = models.CharField(max_length=30, blank=True, null=True)
    state = models.CharField(max_length=2, blank=True, null=True)
    zip_code = models.CharField(max_length=5, blank=True, null=True)
    phone = models.CharField(max_length=10, blank=True, null=True)

    def __str__(self):
        return self.username


class Pairings(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4())
    member1Id = models.IntegerField()
    member2Id = models.IntegerField()
    groupID = models.IntegerField()

    def __str__(self):
        return f'{self.member_1ID}, {self.member_2ID}, {self.groupID}'


class User_By_Group(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4())
    member_1ID = models.ForeignKey(Members, on_delete=models.CASCADE)
    group_ID = models.ForeignKey(myGroups, on_delete=models.CASCADE)


class Wishlist(models.Model):
    id = models.UUIDField(primary_key=True, default=uuid.uuid4())
    ubg_ID = models.ForeignKey(User_By_Group, on_delete=models.CASCADE)
    item_name = models.CharField(max_length=128)

