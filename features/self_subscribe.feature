Feature: Student self-subscribe to or self-unsubscribe from group
  As a student
  So that I can receive more emails
  I want to be able to subscribe to new groups
  
Background: users in database
Given the following users exist:
    | first_name  | last_name | email                  | password | status  | graduation_date |   
    | Bob         | Manman    | jbsmith123@citadel.edu | pass123  | student | 12/12/12        |
  
Given the following groups exist:
    | title | description          |
    | ACM   | The compsci club     |
    | Cybersecurity | Cool hackers |
    | Computer Science | Computer Science Department | 
  
Scenario:
  Given I am on the student details page for "jbsmith123@citadel.edu"
  When I subscribe to "Cybersecurity"
  Then the user should be subscribed to "Cybersecurity"
  
Scenario:
  Given I am on the student details page for "jbsmith123@citadel.edu"
  When I unsubscribe from "Cybersecurity"
  Then the user should be unsubscribed from "Cybersecurity"