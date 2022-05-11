Feature: Login user
  As a user
  So that I can access the communication helper
  I want to be able to login

Scenario: Access the system
    Given I am on the login page
    When I fill in "Email" with "jbsmith124@citadel.edu"
    And I fill in "Password" with "password567"
    And I press "Submit"
    Then I am on the home page

Scenario: Login as admin
    Given I am on the login page
    When I fill in "Email" with "mverdicc@citadel.edu"
    And I fill in "Password" with "password1234"
    And I press "Submit"
    Then I am on the home page

Scenario: Login as student
    Given I am on the login page
    When I fill in "Email" with "jbsmith124@citadel.edu"
    And I fill in "Password" with "password567"
    And I press "Submit"
    Then I am on the home page

Scenario: Should not be able to login
  Given I am on the login page
  When I fill in "Email" with "jdoe@citadel.edu"
  And I fill in "Password" with "pass"
  And I press "Submit"
  Then I am on the login page
