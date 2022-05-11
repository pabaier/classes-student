When /^(?:|I )check the following groups: ([^"]*)$/ do |group_list|
  group_list.split.each do |group|
    group_id = Group.find_by_title(group).id
    check("groups_#{group_id}", allow_label_click: true)
  end
end

When /^(?:|I )uncheck the following groups: ([^"]*)$/ do |group_list|
  group_list.split.each do |group|
    group_id = Group.find_by_title(group).id
    uncheck("groups_#{group_id}", allow_label_click: true)
  end
end

When("I filter for the following groups: {string}") do |group_list|
  group_list.split.each do |group|
    group_id = Group.find_by_title(group).id
    check("groups_#{group_id}", allow_label_click: true)
  end
  steps %Q{
      When I press "Refresh"
    }
end

Given("the user {string} belongs to the groups {string}") do |user_id, groups|
  user = User.find_by_id(user_id)
  
  groups.split(", ").each do |group_id|
    group = Group.find_by_id(group_id)
    user.groups << group
  end
end

Then /^(?:|I )should see the following users: ([^"]*)$/ do |users_list|
  users_list.split(" ").each do |user|
    steps %Q{
      Then I should see "#{user}"
    }
  end
end

Then /^(?:|I )should not see the following users: ([^"]*)$/ do |users_list|
  users_list.split(" ").each do |user|
    steps %Q{
      Then I should not see "#{user}"
    }
  end
end
