Feature: add/delete groups
  As an admin
  So that I can email the correct groups of people
  I want to be able to manage groups

Background: users in database
  Given the following groups exist:
    | title | description |
    | ACM Club  | The compsci club |
  
#Assuming that we have a home page that lists all groups
Scenario: Add new group
  Given I am on the home page
  Then I should not see "Cyber Club"
  When I follow "Create a group"
  Then I should be on the create group page
  When I fill in "Title" with "Cyber Club"
  When I press "Confirm"
  Then I should be on the home page
  Then I should see "Cyber Club"
  
Scenario: Cancel creation of a new group
  Given I am on the home page
  Then I should not see "WiC Club"
  When I follow "Create a group"
  Then I should be on the create group page
  When I fill in "Title" with "WiC Club"
  When I follow "Back"
  Then I should be on the home page
  Then I should not see "WiC Club"
  
Scenario: Delete a group
  Given I am on the home page
  Then I should see "ACM Club"
  When I press "Delete"
  Then I should be on the home page
  Then I should not see "The compsci club"
