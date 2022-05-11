When("I subscribe to {string}") do |group|
    group_id = Group.find_by_title(group).id
    check("user_group_ids_#{group_id}", allow_label_click: true)
    click_button("Update User")
end

When("I unsubscribe from {string}") do |group|
    group_id = Group.find_by_title(group).id
    uncheck("user_group_ids_#{group_id}", allow_label_click: true)
    click_button("Update User")
end

Then("the user should be subscribed to {string}") do |group|
   group_id = Group.find_by_title(group).id
     steps %Q{
         Then the "user_group_ids_#{group_id}" checkbox should be checked
    }
end

Then("the user should be unsubscribed from {string}") do |group|
   group_id = Group.find_by_title(group).id
     steps %Q{
         Then the "user_group_ids_#{group_id}" checkbox should not be checked
    }
end
