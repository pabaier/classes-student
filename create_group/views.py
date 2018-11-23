from django.shortcuts import render, redirect
from .models import myGroups
from .forms import newGroupForm
from members.models import Members,User_By_Group, Pairings
from members.forms import newMembersForm
from django.views.decorators.csrf import csrf_exempt
import simplejson as json
from django.http import JsonResponse

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

def edit_group(request):
    if not request.user.is_authenticated:
        return redirect('members:signup')
    else:
        form1 =newGroupForm()
        context = {
           'form1': form1,
        }
        return render(request,'edit_group.html',context)

def make_pairs(request, groupId):
  if request.user.is_authenticated:
    usersGroups = User_By_Group.objects.filter(member_1ID=request.user.id)
    requestUserInGroup = any(ubgObject.group_ID.id == groupId for ubgObject in usersGroups)
    if requestUserInGroup:
      group = myGroups.objects.get(id=groupId)
      usersInGroup = User_By_Group.objects.filter(group_ID = group)
      for ubgObject in usersInGroup:
        print(ubgObject.member_1ID.username)
      print(len(usersInGroup))
    # if (groupId == 0):
    #   return JsonResponse({'success': False})
    # # managed_list = myGroups.objects.all().filter(created_by=request.user.username)
    return JsonResponse({'success': requestUserInGroup})

