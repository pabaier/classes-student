Feature: Remove user from system
    As an admin
    So that I can stop contacting a student
    I want to be able to remove a student from the communication helper database
  
Background: users in database
  Given the following users exist:
  | first_name  | last_name | email                 | password | status  | graduation_date |   
  | Bob         | Manman    | jbsmith123@citadel.edu | pass123  | student | 12/12/12 |
  | Jan         | Tinkerton    | tinkerbell88@neverland.pixi | peter  | Admin | 1/2/20 |  

  Given the following groups exist:
   |id | title         | description      |
   |1  | ACM           | The compsci club |
   |2  | Cybersecurity | Cool hackers     |

  Given the user "1" belongs to the groups "1, 2"
  Given the user "2" belongs to the groups "1, 2"

Scenario: Press 'delete' to remove user
  Given I am on the users page
  When I press "del_jbsmith123@citadel.edu"
  Then I should not see "jbsmith123@citadel.edu"
  And I should see "tinkerbell88@neverland.pixi"
  
Scenario: Press 'delete' but keep Admin
  Given I am on the users page
  Then I should see "tinkerbell88@neverland.pixi"
  When I press "del_tinkerbell88@neverland.pixi"
  Then I should see "tinkerbell88@neverland.pixi"
