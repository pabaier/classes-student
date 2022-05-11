# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

users = [
    {:first_name => 'Michael', :last_name => 'Verdicchio', :email => 'mverdicc@citadel.edu',
    :password => 'password1234', :status => 'Admin', :graduation_date => '3-May-2000'} ,
    {:first_name => 'Stephanie', :last_name => 'Martina', :email => 'sm@gmail.edu',
    :password => 'password1234', :status => 'Student', :graduation_date => '3-May-2000'}

    ]
    
users.each do |user|
   User.create!(user) 
end

groups = [
    {:title => "Cybersecurity", :description => "Cool hacker club"},
    {:title => "Math Club", :description => "Very Exact"},
    {:title => "Computer Science", :description => "Computer Science Department"}
    ]
    
groups.each do |group|
    Group.create!(group)
end

# groups_users = [
#     {:user_id => 1, :group_id => 1},
#     {:user_id => 2, :group_id => 2}
#     ]

Group.find(1).users << User.find(1)
Group.find(2).users << User.find(2)

#Add users to Computer Science Group
Group.find(3).users << User.find(1)
Group.find(3).users << User.find(2)

# groups_users.each do |connection|
#     Group.users << connection
# end
