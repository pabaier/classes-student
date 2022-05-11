class GroupsController < ApplicationController
  def group_params
    params.require(:group).permit(:title, :description)
  end
  
  def index
    @groups=Group.all
  end
    
  def new
    # default: render 'new' template
  end
  
  def create
    @group = Group.create!(group_params)
    flash[:notice] = "#{@group.title} was successfully created."
    redirect_to groups_path
  end
  
  def show
    id = params[:id] # retrieve group ID from URI route
    @group = Group.find(id) # look up group by unique ID
    # will render app/views/groups/show.<extension> by default
  end

  def edit
    @group = Group.find params[:id]
  end
  
  def destroy
    @group = Group.find(params[:id])
    
    if (@group.title == 'Computer Science') 
      flash[:notice] = "Group '#{@group.title}' cannot be deleted."
    else
      @group.destroy
      flash[:notice] = "Group '#{@group.title}' is deleted."
    end
    redirect_to groups_path
  end
end