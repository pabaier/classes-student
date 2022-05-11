Feature: Filter users by group
# Background: As an admin I should be able to filter users by a group

Background: users in database
  Given the following users exist:
   | first_name  | last_name | email                       | password | status  | graduation_date |   
   | Bob         | Manman    | jbsmith123@citadel.edu      | pass123  | student | 12/12/12        |
   | Jan         | Tinkerton | tinkerbell88@neverland.pixi | peter    | Admin   | 1/2/20          | 
  
  Given the following groups exist:
   |id | title         | description      |
   |1  | ACM           | The compsci club |
   |2  | Cybersecurity | Cool hackers     |

  Given the user "1" belongs to the groups "1, 2"
  Given the user "2" belongs to the groups "1"

#   Given I am on the users page
#   Then 2 seed users should exist
  
Scenario: Check ACM and Cybersecurity
    # enter step(s) to check the 'ACM' and 'Cybersecurity' checkboxes
    Given I am on the student details page
	When I check the following groups: ACM Cybersecurity

    # enter step to "submit" the search form on the user page
    #Refresh is the value associated with the submit input type
	And I press "Refresh"
    # enter step(s) to ensure that ACM and Cybersecurity users are visible
    And I should see the following users: Bob Jan  

Scenario: Check ACM only
    # enter step(s) to check the 'ACM' checkboxes
    Given I am on the student details page
	When I check the following groups: ACM

    # enter step(s) to uncheck all other checkboxes
	And I uncheck the following groups: Cybersecurity

    # enter step to "submit" the search form on the user page
    #Refresh is the value associated with the submit input type
	And I press "Refresh"
    # enter step(s) to ensure that ACM users are visible
    Then I should see the following users: Bob Jan

    
Scenario: Check Cybersecurity only
    # enter step(s) to check the 'Cybersecurity' checkboxes
    Given I am on the student details page
	When I check the following groups: Cybersecurity

    # enter step(s) to uncheck all other checkboxes
	And I uncheck the following groups: ACM

    # enter step to "submit" the search form on the user page
    #Refresh is the value associated with the submit input type
	And I press "Refresh"
    # enter step(s) to ensure that Cybersecurity users are visible
    Then I should see the following users: Bob 

    # enter step(s) to ensure that other users are not visible
    And I should not see the following users: Jan
