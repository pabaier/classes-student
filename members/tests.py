from django.test import TestCase
from .models import Members, Pairings, User_By_Group, Wishlist
from create_group.models import myGroups
import datetime

class MembersTestCase(TestCase):
    def setUp(self):
        userOne = Members.objects.create(
          username = "one",
          street = "107 Blueberry Lane", 
          state = "SC",
          zip_code = "15219",
          phone = "1234567890"
        )
        userTwo = Members.objects.create(
          username = "two",
          street = "107 Blueberry Lane", 
          state = "SC",
          zip_code = "15219",
          phone = "1234567890"
        )
        groupOne = myGroups.objects.create(
          group_name = "Group One",
          end_date = datetime.datetime(11,11,11),
          ship_date = datetime.datetime(12,12,12),
          created_by = "me"
        )
        Pairings.objects.create(
          member_1ID = 7,
          member_2ID = 10,
          groupID = 3
        )
        userGroup = User_By_Group.objects.create(
          member_1ID = userOne,
          group_ID = groupOne
        )
        Wishlist.objects.create(
          ubg_ID = userGroup,
          item_name = "red ryder bb gun"
        )

    def test_recordsExist(self):
        """Some records exist in members model"""
        allMembers = Members.objects.all()
        self.assertEqual(allMembers.filter(username='one').exists(), True)
        self.assertEqual(allMembers.filter(username='two').exists(), True)
        self.assertEqual(allMembers.filter(username='three').exists(), False)


        """Some records exist in pairings model"""
        allPairings = Pairings.objects.all()
        self.assertEqual(allPairings.filter(member_1ID=7).exists(), True)

        """Some records exist in user/group model"""
        allUserGroups = User_By_Group.objects.all()
        self.assertEqual(allUserGroups.filter(member_1ID=1).exists(), True)
        self.assertEqual(allUserGroups.filter(member_1ID=2).exists(), False)


        """Some records exist in user/group model"""
        allWishlists = Wishlist.objects.all()
        self.assertEqual(allWishlists.filter(ubg_ID=1).exists(), True)
        self.assertEqual(allWishlists.filter(item_name="red ryder bb gun").exists(), True)
        self.assertEqual(allWishlists.filter(item_name="decoder ring").exists(), False)



