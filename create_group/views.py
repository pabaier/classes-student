from django.shortcuts import render
from .import forms
from create_group.models import myCustomGroup,myCustomUsers
from create_group.forms import newGroupForm,newUsersForm
from django.conf import settings
from django.shortcuts import redirect



# Create your views here.

def index(request):
    return render(request,'dashboard.html')

def form_view(request):
    form1 =newGroupForm()
    #form2 = newUsersForm()

    if request.method == "POST":
        form1 = newGroupForm(request.POST)
        #if request.method == 'POST':
        print(request.POST.get('cell_value'))
        if request.POST.get('Name') and request.POST.get('Email') and request.POST.get('Phone') and request.POST.get('Address') and request.POST.get('Exclusions'):
                post=newUsersForm()
                post.user_name= request.POST.get('Name')
                post.user_email= request.POST.get('Email')
                post.user_phone= request.POST.get('Phone')
                post.user_address= request.POST.get('Address')
                post.user_exclusions= request.POST.get('Exclusions')
                post.save()
        else:
            print('Error - Invalid Form')

        #form2 = newUsersForm(request.POST)
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
#def show_myGroups(request):
#    group_list = myCustomUsers.objects.order_by('user_group')
#    group_dict = {'myGroups':group_list}
#    return render (request,'dashboard.html',context=group_dict)


def show_myGroups(request):
    if not request.user.is_authenticated:
        return redirect('%s?next=%s' % (settings.LOGIN_URL, request.path))
    else:
        group_list = myCustomUsers.objects.all().filter(user_email=request.user.email)
        group_dict = {'myGroups':group_list}
        return render (request,'dashboard.html', context=group_dict)

def show_myManaged(request):
    if not request.user.is_authenticated:
        return redirect('%s?next=%s' % (settings.LOGIN_URL, request.path))
    else:
        managed_list = myCustomGroup.objects.all().filter(created_by=request.user.email)
        managed_dict = {'myManager':managed_list}
        return render (request,'dashboard.html', context=managed_dict)