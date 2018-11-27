from django.shortcuts import render, redirect
from .models import myGroups
from .forms import newGroupForm
from members.models import Members,User_By_Group, Pairings, Exclusions
from members.forms import newMembersForm
from django.views.decorators.csrf import csrf_exempt
import simplejson as json
from django.http import HttpResponse, JsonResponse
from django.forms.models import model_to_dict
import operator
import random
from .forms import PostForm
from django.utils.datastructures import MultiValueDictKeyError
from comms.views import newUser

def index(request):
  if request.user.is_authenticated:
    return render(request, 'dashboard.html')
  else:
    return redirect('members:signup')

@csrf_exempt
def form_view(request):
  if request.user.is_authenticated:
    form1 =newGroupForm()
    if request.is_ajax():

        temp = request.POST['grpInfo']
        groupData= json.loads(temp)
        myGroup = myGroups()
        if request.POST['grpInfo'] and request.POST['arr']:
            myGroup.group_name= groupData['groupName']
            myGroup.end_date = groupData['endDate']
            myGroup.ship_date = groupData['shipDate']
            myGroup.created_by = groupData['createdBy']
            myGroup.save()
            #return show_groups(request)

            array_data = request.POST['arr']
            data = json.loads(array_data)
            group = myGroups.objects.get(id=myGroup.id)
            userByGroup = User_By_Group()
            userByGroup.member_1ID = request.user
            userByGroup.group_ID = group
            userByGroup.save()

            for user in data:
                myUser = Members()
                myUser.first_name = user['firstName']
                myUser.last_name = user['lastName']
                myUser.username = user['Username']
                myUser.email = user['Useremail']
                myUser.phone = user['Userphone']
                myUser.address = user['Useraddress']
                myUser.city = user['Usercity']
                myUser.state = user['Userstate']
                myUser.zip_code = user['Userzip']
                myUser.exclusions = user['Exclusions']
                myUser.set_password('SecretSanta1')
                myUser.save()

                # notify user
                newUser(request, myUser.id)

                userByGroup = User_By_Group()
                userByGroup.group_ID = group
                userByGroup.member_1ID = myUser
                userByGroup.save()
        else:
            print('Error - Invalid Form- user table/group form')

    context = {
       'form1': form1,
    }
    return render(request, 'create.html',context)
  else:
    return redirect('members:signup')

# shows group memberships and groups managed on Dashboard
def show_groups(request):
    if not request.user.is_authenticated:
        return redirect('members:signup')
    else:
        membership_list = User_By_Group.objects.all().filter(member_1ID=request.user)
        groupList = []
        for m in membership_list:
          groupList.append(m.group_ID)
        managed_list = myGroups.objects.all().filter(created_by=request.user.username)
        context = {'myManaged': managed_list, 'myMembership': groupList}
        return render(request, 'dashboard.html', context)

@csrf_exempt
def edit_group(request,groupID='Default'):
  if not request.user.is_authenticated:
      return redirect('members:signup')
  else:
    if request.is_ajax():
      if request.POST.get('deleteMemberValue', False):
        try:
          varValue = request.POST['deleteMemberValue']

          #delete user from members table having username varValue and updatein group by memeber tableRow
          members_tobe_delelted = Members.objects.get(username = varValue)
          group = myGroups.objects.get(id=request.POST['groupId'])
          User_By_Group.objects.get(group_ID=group, member_1ID=members_tobe_delelted).delete()
          # members_tobe_delelted.delete()
          # return redirect('create_group:dashboard')
        except MultiValueDictKeyError:
          print("No data to delete")
        return JsonResponse({'success': True})
      elif request.POST.get('editarr', False):
        array_data = request.POST['editarr']
        data = json.loads(array_data)
        count = len(data)
        for user in data:
            myUser = Members()
            myUser.first_name = user['firstName']
            myUser.last_name = user['lastName']
            myUser.username = user['Username']
            myUser.email = user['Useremail']
            myUser.phone = user['Userphone']
            myUser.address = user['Useraddress']
            myUser.exclusions = user['Exclusions']
            myUser.set_password('SecretSanta1')
            myUser.save()

            # notify user
            newUser(request, myUser.id)

        userByGroup = User_By_Group()
        userByGroup.member_1ID = Members.objects.get(id = myUser.id)
        userByGroup.group_ID = myGroups.objects.get(id=groupID)
        userByGroup.save()
        return JsonResponse({'success': True})
    else:
      #getting members info from url parameter -groupID
      groupOb = myGroups.objects.get(id=groupID)
      userByGrp = (User_By_Group.objects.all().filter(group_ID=groupOb.id))
      listOfUsers=list(userByGrp)
      my_dict = {}
      for userObj1 in listOfUsers:
        userInfo = Members.objects.all().filter(username=userObj1.member_1ID)
        for oneUser in userInfo:
          my_dict.setdefault(oneUser.username,[]).append(oneUser)
      #editing group info - using django forms
      form1 =newGroupForm(instance=groupOb)
      if request.method == "POST":
        form2 = PostForm(request.POST,instance=groupOb)
        if form2.is_valid():
          post = form2.save(commit=False)
          post.save()
          return redirect('create_group:dashboard')
      else:
          form2 = PostForm(instance=groupOb)
          #return render(request,'edit_group.html',{'form2':form2})

      #for edit button - getting new members info to be added to the group
      
      #sending information to be edited to the template
      context = {
              'form2': form2,
              'message': my_dict,
              'groupId': groupID
      }
      return render(request,'edit_group.html',context)

def make_pairs(request, groupId):
  if request.user.is_authenticated:
    usersGroups = User_By_Group.objects.filter(member_1ID=request.user.id)
    requestUserInGroup = any(ubgObject.group_ID.id == groupId for ubgObject in usersGroups)
    if requestUserInGroup:
      groupObject = myGroups.objects.get(id=groupId)
      usersInGroupObject = User_By_Group.objects.filter(group_ID = groupId)
      groupExclusionsObject = Exclusions.objects.filter(group = groupId)

      # turn all querysets into dicts
      # group = model_to_dict(groupObject)
      groupExclusions = []
      usersOnly = []
      userIdWithObject = {}
      for ubg in usersInGroupObject:
        userIdWithObject[ubg.member_1ID.id] = ubg.member_1ID
        usersOnly.append(ubg.member_1ID.id)
      for ex in groupExclusionsObject:
        groupExclusions.append(model_to_dict(ex))

      # consolidate info to an array of objects of [{userId: []},...]
      allUsers = []
      for userId in usersOnly:
        a = {userId: usersOnly.copy()}
        for e in groupExclusions:
          if e['owner'] is userId:
            a[userId].remove(e['excluded'])
        a[userId].remove(userId)
        allUsers.append(a)

      def sortKey(a):
        return len(a[list(a)[0]])
      # sort the object so the users with the least amount of options are first
      allUsers.sort(key=sortKey)

      # pair everyone up! 'pairs' is {<userId>:<partnerId>, ...}
      pairs={}
      flag = 0
      counter = 0
      success = True
      allUsersOG = allUsers.copy()
      while flag is 0:
        allUsers = allUsersOG.copy()
        flag = -1
        counter += 1
        # stop after one million attempts
        if counter > 1000000:
          success = False
          break
        while(len(allUsers) > 0):
          user = list(allUsers[0])[0]
          userOptions = allUsers[0][user]
          if len(userOptions) == 0:
            flag = 0
            break
          partner = userOptions.pop(random.randint(0, len(userOptions)-1))
          pairs[user] = partner
          for u in allUsers:
            try:
              u[list(u)[0]].remove(partner)
            except:
              pass
          allUsers.pop(0)
          allUsers.sort(key=sortKey)

      if success:
        Pairings.objects.filter(groupID=groupId).delete()
        for pair in pairs:
          Pairings(member_1ID=userIdWithObject[pair], member_2ID=userIdWithObject[pairs[pair]], groupID=groupObject).save()
        return JsonResponse({'success': True})
      else:
        return JsonResponse({'success': False, 'message': 'Sorry, we were unable to find the right pairing combinations. Please check the group\'s exceptions and try again.'})
    return JsonResponse({'success': False, 'message': 'Sorry, you are not a member of this group.'})
  else:
    return redirect('members:signup')

@csrf_exempt
def join_group(request):
    if not request.user.is_authenticated:
        return redirect('members:signup')
    else:
        my_dict = {}
        myGs = User_By_Group.objects.filter(member_1ID=request.user)
        groupsList = myGroups.objects.filter(public=True)
        # print(groupsList)
        for g in myGs:
          print(g.group_ID.id)
          groupsList = groupsList.exclude(id=g.group_ID.id)
          # try:
        # print(groupsList)
        for grp in groupsList:
            my_dict.setdefault(grp.id,grp.group_name)
        
        context={
        'messsge':my_dict
        }
        if request.is_ajax():
             if request.POST['group']:
                grpData = request.POST['group']
                data = json.loads(grpData)
                print(data)
                userByGroup = User_By_Group()
                userByGroup.member_1ID = Members.objects.get(id = request.user.id)
                userByGroup.group_ID = myGroups.objects.get(id=data)
                userByGroup.save()
                return JsonResponse({'success': True})
    return render (request, 'join_group.html',context)

def add_user(request, groupId, username):
  group = myGroups.objects.get(id=groupId)
  try:
    user = Members.objects.get(username=username)
  except Exception as err:
    return JsonResponse({'success': False, 'message': f'User {username} does not exist'})
  try:
    User_By_Group(group_ID=group, member_1ID=user).save()
  except Exception as err:
    return JsonResponse({'success': False, 'message': f'Sorry we could not add user {username} to that group'})
  return JsonResponse({'success': True})
