class UsersController < ApplicationController
  require 'csv'

  def index
    @all_users=User.all
    @all_groups=Group.all
    @all_delimiters = [",", ";"]
    
    @selected_users = Array.new
    @selected_emails = Array.new
  
    #This gives us the ids  
    @selected_groups = params[:groups] || session[:groups] || {}
    
    if @selected_groups == {}
      @selected_groups = Hash[@all_groups.map {|group| [group.title, group.id]}]
    end
    
    @selected_groups.values.each do |group_id|
      Group.find(group_id).users.each do |user|
        #maintain uniqueness
        if !@selected_users.include? user
          @selected_users.push(user)
          @selected_emails.push(user.email)
        end
      end
    end
    
    if session[:emails] != @selected_emails
      session[:emails] = @selected_emails
    end
    
    if params[:groups] != session[:groups]
      session[:groups] = @selected_groups
      flash.keep
      redirect_to :groups => @selected_groups and return
    end
    
  end
  
  def user_params
    params.require(:user).permit(:first_name, :last_name, :email, :password, :graduation_date, :status, :group_ids => [])
  end
  
  def new
    @all_groups=Group.all
  end
  
  def edit
    @user = User.find params[:id]
  end
  
  def show
    @user = User.find params[:id]
    @groups=Group.all
  end
  
  def add_to_default_group new_user
    @cs_group = Group.where(title: 'Computer Science').first
    @cs_group_id = @cs_group.id
    
    @selected_groups = params[:groups] || {}
    
    if @selected_groups == {}
      @selected_groups = {@cs_group.title => @cs_group_id}
    end
    
    if !@selected_groups.has_key?('Computer Science')
      @selected_groups.merge({@cs_group.title => @cs_group_id})
    end

    @selected_groups.values.each do |group_id|
      group = Group.find(group_id)
      new_user.groups << group
    end
    
  end
  
  def create
    @user = User.create!(user_params)
    add_to_default_group @user
    flash[:notice] = "#{@user.first_name} #{@user.last_name} was successfully created."
    redirect_to users_path
  end

  def update
    @user = User.find params[:id]
  
    @cs_group_id = Group.find_by_title('Computer Science').id
    
    if !params[:user][:group_ids].include?(@cs_group_id)
      flash[:notice] = "#{@user.first_name} #{@user.last_name} must have Computer Science."
      params[:user][:group_ids].push(@cs_group_id)
    end
    
    
    @user.update_attributes!(user_params)
    flash[:notice] = "#{@user.first_name} was successfully updated."
    redirect_to edit_user_path(@user)
  end
  
  def import
    if params.key?(:file) then
      result = User.import(params[:file])
      valid_users = result[0]
      errors = result[1]
      valid_users.each do |user|
        add_to_default_group user
      end
      if errors.length >= 1 then
        flash[:notice] = "Unable to import #{errors.length} users:#{errors}"
      else
        flash[:notice] = "Data imported successfully"
      end
    else
      flash[:notice] = "No file selected!"
    end
    redirect_to users_path
      # redirect_to users_path, notice: "Data imported successfully"
  end
  
  def destroy
    @user = User.find params[:id]
    if @user.status == 'Admin'
      flash[:notice] = "#{@user.last_name} cannot be removed."
    else
      flash[:notice] = "#{@user.last_name} was successfully removed."
      User.delete(@user.id)
    end
    redirect_to users_path

  end
  
  def export
    @emails = session[:emails] || []
    @delimiter = params[:delimiter]
  end
end
