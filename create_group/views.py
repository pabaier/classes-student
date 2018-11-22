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
                myUser.save()

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
        membership_list = Members.objects.all().filter(id=request.user.id)
        managed_list = myGroups.objects.all().filter(created_by=request.user.username)
        context = {'myManaged': managed_list, 'myMembership': membership_list}
        return render(request, 'dashboard.html', context)

@csrf_exempt
def edit_group(request,groupname='Default'):
    if not request.user.is_authenticated:
        return redirect('members:signup')
    else:

        groupOb = myGroups.objects.get(group_name=groupname)
    #    userByGrpOb= User_By_Group.objects.get(group_ID=groupOb.id)
        form1 =newGroupForm(instance=groupOb)
        if form1.is_valid():
            form1.save()
            context = {
                'form1': form1,
                #'GroupName' : format(groupOb.group_name)
                }
            return render(request,'edit_group.html',context)

        return render(request,'edit_group.html',{'form1':form1})
        #return HttpResponse('<h1>Group is {}</h1>'.format(userByGrpOb.member_1ID)) #get members from selected group

def make_pairs(request, groupId):
  if request.user.is_authenticated:
    usersGroups = User_By_Group.objects.filter(member_1ID=request.user.id)
    requestUserInGroup = any(ubgObject.group_ID.id == groupId for ubgObject in usersGroups)
    if requestUserInGroup:
      groupObject = myGroups.objects.get(id=groupId)
      usersInGroupObject = User_By_Group.objects.filter(group_ID = groupObject)
      groupExclusionsObject = Exclusions.objects.filter(group = groupObject)

      # turn all querysets into dicts
      # group = model_to_dict(groupObject)
      usersByGroup = []
      groupExclusions = []
      usersOnly = []
      userIdWithObject = {}
      for ubg in usersInGroupObject:
        userIdWithObject[ubg.member_1ID.id] = ubg.member_1ID
        usersByGroup.append(model_to_dict(ubg))
        usersOnly.append(ubg.member_1ID.id)
      for ex in groupExclusionsObject:
        groupExclusions.append(model_to_dict(ex))

      # consolidate info to an array of objects of {userId: #, exclusions: [], options: []}
      allUsers = []
      for user in usersByGroup:
        userId = user['member_1ID']
        a = {'userId': userId, 'exclusions': [], 'options': usersOnly.copy()}
        for e in groupExclusions:
          if e['owner'] is userId:
            a['exclusions'].append(e['excluded'])
            a['options'].remove(e['excluded'])
        a['options'].remove(userId)
        allUsers.append(a)

      # sort the array so the users with the least amount of options are first
      allUsers.sort(key=operator.itemgetter('options'), reverse=True)

      # pair everyone up!
      pairs=[]
      flag = 0
      counter = 0
      success = True
      usersLeft = usersOnly.copy()
      while flag is 0:
        flag = -1
        counter += 1
        # stop after one million attempts
        if counter > 1000000:
          success = False
          break
        for user in allUsers:
          userOptions = user['options']
          if len(userOptions) == 0:
            flag = 0
            break
          pair = {'userId': user['userId']}
          partner = userOptions.pop(random.randint(0, len(userOptions)-1))
          pair['partnerId'] = partner
          pairs.append(pair)
          for user in allUsers:
            try:
              user['options'].remove(partner)
            except:
              pass

      if success:
        Pairings.objects.filter(groupID=groupObject).delete()
        for pair in pairs:
          Pairings(member_1ID=userIdWithObject[pair['userId']], member_2ID=userIdWithObject[pair['partnerId']], groupID=groupObject).save()
        return JsonResponse({'success': True})
      else:
        return JsonResponse({'success': False, 'message': 'Sorry, we were unable to find the right pairing combinations. Please check the group\'s exceptions and try again.'})
    return JsonResponse({'success': False, 'message': 'Sorry, you are not a member of this group.'})
  else:
    return redirect('members:signup')



