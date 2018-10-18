from django.db import models

class Pairings(models.Model):
    member_1ID = models.IntegerField()
    member_2ID = models.IntegerField()
    groupID = models.IntegerField()

    def __str__(self):
        return f'{self.member_1ID}, {self.member_2ID}, {self.groupID}'