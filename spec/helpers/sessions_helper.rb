require 'rails_helper'

describe "log in user" do
    it "should start a session with user's id" do
        @user = User.create!(:id => 1)
        expect(log_in(@user)).to eq(1)
    end
end