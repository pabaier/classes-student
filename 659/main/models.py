from django.db import models

class Member_Group(models.Model):
    memberID = models.IntegerField()
    groupID = models.IntegerField()
    isOwner = models.BooleanField()

    def __str__(self):
        return self.memberID