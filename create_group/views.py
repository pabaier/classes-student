from django.shortcuts import render
from django.shortcuts import redirect
from .models import myGroups
from .forms import newGroupForm
from members.models import Members
from members.forms import newMembersForm
from django.views.decorators.csrf import csrf_exempt
import simplejson as json

# Create your views here.

def index(request):
    return render(request, 'dashboard.html')


@csrf_exempt
def form_view(request):
    form1 = newGroupForm()
    # form2 = newMembersForm()

    if request.is_ajax():
           #make db table instace of extended user table
        array_data = request.POST['arr']
        data = json.loads(array_data)
        print(data)
        print(data[0])
        #print(data[8])

        if request.POST['arr']:
            count = len(data)
            print(len(data))
            index = 0
            while index<count:
                myUser = Members()
                myUser.name = data[index];
                print(data[index])
                myUser.username = data[index+1];
                print(data[index+1])
                myUser.email = data[index+2];
                print(data[index+2])
                myUser.phone = data[index+3];
                print(data[index+3])
                myUser.address = data[index+4];
                print(data[index+4])
                myUser.exclusions = data[index+5];
                print(data[index+5])
                myUser.save()
                index = index+6;

    else:
        print('Error - Invalid Form')


    if form1.is_valid():
        form1.save()
            #form2.save()
        return show_myGroups(request)
    else:
        print('Error - Invalid Form')

    context = {
        'form1': form1,
        # 'form2':form2
    }
    return render(request, 'create.html', context)


# shows group memberships and groups managed on Dashboard
def show_groups(request):
    if not request.user.is_authenticated:
        return redirect('members:signup')
    else:
        membership_list = Members.objects.all().filter(id=request.user.id)
        managed_list = myGroups.objects.all().filter(created_by=request.user.email)
        context = {'myManaged': managed_list, 'myMembership': membership_list}
        return render(request, 'dashboard.html', context)
