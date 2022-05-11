require 'rails_helper'
require 'spec_helper'

describe SessionsController do
     describe "#new" do
         it 'should show login page' do
            get :new
            expect(response).to render_template("sessions/new")
         end
     end
end