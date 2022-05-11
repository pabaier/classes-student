Feature: Export a list of emails for students in selected groups
  
  Background: users belong to groups in the database
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
  
  Scenario: Export users in selected groups
    Given I am on the student details page
	 When I filter for the following groups: "Cybersecurity"
	And I press "Export table"
	Then I should be on the export page
	And I should see "jbsmith123@citadel.edu"
	
  Scenario: Choose delimiter
    Given I am on the student details page
    When I filter for the following groups: "ACM"
    And I choose the delimiter ";"
    And I press "Export table"
    Then I should be on the export page
    And I should see "jbsmith123@citadel.edu; tinkerbell88@neverland.pixi"
	