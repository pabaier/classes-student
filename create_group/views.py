from django.shortcuts import render
from django.shortcuts import redirect
from .models import myGroups
from .forms import newGroupForm
from members.models import Members,User_By_Group
from members.forms import newMembersForm
from django.views.decorators.csrf import csrf_exempt
import simplejson as json



def index(request):
    return render(request, 'dashboard.html')


@csrf_exempt
def form_view(request):
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
            print(myGroup.id)
            #return show_groups(request)

            array_data = request.POST['arr']
            data = json.loads(array_data)
            print(data)
            print(data[0])
            count = len(data)
            print(len(data))
            for user in data:
                myUser = Members()
                myUser.first_name = user['firstName']
                myUser.last_name = user['lastName']
                myUser.username = user['Username']
                myUser.email = user['Useremail']
                myUser.phone = user['Userphone']
                myUser.address = user['Useraddress']
                myUser.exclusions = user['Exclusions']
                myUser.save()
                print(myUser.id)

                userByGroup = User_By_Group()
                userByGroup.member_1ID = Members.objects.get(id = myUser.id)
                userByGroup.group_ID = myGroups.objects.get(id=myGroup.id)
                userByGroup.save()

        else:
            print('Error - Invalid Form- user table/group form')


    context = {
       'form1': form1,
    }
    return render(request, 'create.html',context)


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
