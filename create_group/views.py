from django.shortcuts import render
from . import forms
from members.models import Members
from create_group.models import myGroups
from create_group.forms import newGroupForm
from members.forms import newMembersForm
from django.conf import settings
from django.shortcuts import redirect
from members.models import Members


# Create your views here.

def index(request):
    return render(request, 'dashboard.html')


def form_view(request):
    form1 = newGroupForm()
    # form2 = newMembersForm()

    if request.method == "POST":
        form1 = newGroupForm(request.POST)
        # if request.method == 'POST':
        print(request.POST.get('cell_value'))
        if request.POST.get('Name') and request.POST.get('Email') and request.POST.get('Phone') and request.POST.get(
                'Address') and request.POST.get('Exclusions'):
            post = newMembersForm()
            post.user_name = request.POST.get('Name')
            post.user_email = request.POST.get('Email')
            post.user_phone = request.POST.get('Phone')
            post.user_address = request.POST.get('Address')
            post.user_exclusions = request.POST.get('Exclusions')
            post.save()
        else:
            print('Error - Invalid Form')

        # form2 = newMembersForm(request.POST)
        if form1.is_valid():
            form1.save()
            # form2.save()
            return show_groups(request)
        else:
            print('Error - Invalid Form')

    context = {
        'form1': form1,
        # 'form2':form2
    }
    return render(request, 'form_page.html', context)


# shows group memberships and groups managed on Dashboard
def show_groups(request):
    if not request.Members.is_authenticated:
        return redirect('' % (settings.LOGIN_URL, request.path))
    else:
        membership_list = Members.objects.all().filter(id=request.Members.id)
        managed_list = myGroups.objects.all().filter(created_by=request.Members.email)
        context = {'myManaged': managed_list, 'myMembership': membership_list}
        return render(request, 'dashboard.html', context)
