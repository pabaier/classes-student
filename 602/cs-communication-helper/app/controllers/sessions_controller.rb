class SessionsController < ApplicationController

  def new
  end

  def create
    @user = User.where("email = '#{params[:session][:email].downcase}'").first
    if @user && @user.authenticate(params[:session][:password])
      log_in @user
      redirect_to "/users/#{@user.id}"
    else
      flash[:error] = "Invalid email/password combination"
      render 'new'
    end
  end

  def destroy
  end
end
