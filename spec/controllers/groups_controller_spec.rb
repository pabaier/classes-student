require 'rails_helper'

describe GroupsController do
    describe "#create" do
        it 'should create a new group object and add it to the db' do
			expect{
			    post :create, { :group => { :title => 'group', :description => 'description'} }
			}.to change(Group, :count).by(1)
		end
    end
    
    describe "#show" do
        it 'should show the specified group object from the db' do
            @group = Group.create(:id => 1, :title => 'group1', :description => 'a group')
            get :show, :id => @group
            expect(response).to render_template("groups/show")
        end
    end
    
    describe "#destroy" do
        it 'should delete a group object from the db' do
            Group.create(:id => 1, :title => 'group')
            expect{ 
                delete :destroy, :id => 1
            }.to change(Group, :count).by(-1)
        end
    end
    
    describe "#index" do
        it 'should show all groups' do
            get :index
            expect(response).to be_success
        end
    end
    
    describe "#new" do
        it 'should show new template' do
            get :new
            expect(response).to render_template("groups/new")
        end
    end
    
    # describe "#update" do
    #     it 'should update a group object from the db' do
    #         @group = Group.create(:id => 1, :title => 'group')
    #         put :update, :id => @group, :group => {:title => 'newgroup'}
    #         @group.reload
    #         expect(@group.title).to eq("newgroup")
    #     end
    # end
    
end