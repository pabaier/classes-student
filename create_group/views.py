from django.shortcuts import render
from .import forms
from create_group.models import myCustomGroup
from create_group.forms import newGroupForm
from django.views.decorators.csrf import csrf_exempt
import simplejson as json

# Create your views here.

def index(request):
    return render(request,'dashboard.html')

@csrf_exempt
def form_view(request):
    form1 =newGroupForm()
    #form2 = newUsersForm()

    if request.is_ajax():
    #    myUser = myCustomUsers()   // make db table instace of extended user table
        array_data = request.POST['arr']
        data = json.loads(array_data)
        print(data)
        print(data[0])
        print(data[8])

        if request.POST['arr']:
            count = len(data)
            print(len(data))
            index = 0
            while index<count:
        #        myUser.user_name = data[index];  // save data to extended user model.
                print(data[index])
        #        myUser.user_email =data[index+1];
                print(data[index+1])
        #        myUser.user_phone = data[index+2];
                print(data[index+2])
        #        myUser.user_address = data[index+3];
                print(data[index+3])
        #        myUser.user_exclusions = data[index+4];
                print(data[index+4])
                index = index+5;
            #myUser.save()
    else:
        print('Error - Invalid Form')


    if form1.is_valid():
        form1.save()
            #form2.save()
        return show_myGroups(request)
    else:
        print('Error - Invalid Form')


    context = {
        'form1':form1,
        #'form2':form2
    }
    return render (request,'form_page.html',context)



def show_myGroups(request):
    group_list = myCustomGroup.objects.order_by('group_name')
    group_dict = {'myGroups':group_list}
    return render (request,'dashboard.html',context=group_dict)
