When /^(?:|I )upload a file with valid data$/ do
  attach_file(:file, File.join('features', 'upload_files', 'good_csv.csv'))
#   attach_file(:csv_file, File.join(RAILS_ROOT, 'features', 'upload_files', 'good_csv.csv'))
  click_button "Import CSV"
end

Then("the number of users should be {int}") do |int|
  User.count.should == int
end
 
When /^(?:|I )upload a bad file$/ do
  attach_file(:file, File.join('features', 'upload_files', 'bad_csv.csv'))
#   attach_file(:csv_file, File.join(RAILS_ROOT, 'features', 'upload_files', 'bad_csv.csv'))
  click_button "Import CSV"
end

When /^(?:|I )upload a duplicate file$/ do
  attach_file(:file, File.join('features', 'upload_files', 'bad_csv.csv'))
#   attach_file(:csv_file, File.join(RAILS_ROOT, 'features', 'upload_files', 'duplicate_csv.csv'))
  click_button "Import CSV"
end


Then("the number of users should not change") do
  User.count.should == 4
end

Then /^I should have the following users:$/ do |table|
  table.hashes.size.should == User.count

  table.hashes.each do |row|
    user = User.find_by_first_name(row['first_name'])
    user.should_not be_nil
  end
end