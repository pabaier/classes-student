When("I choose {string} in {string}") do |date, calendar|
    select_date date, from: calendar
end

Given /the following users exist/ do |users_table|
  users_table.hashes.each do |user|
	  User.create!(user)
  end
end

Given /the following groups exist/ do |groups_table|
  groups_table.hashes.each do |group|
	  Group.create!(group)
  end
end
