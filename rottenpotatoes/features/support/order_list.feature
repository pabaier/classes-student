Feature: sort the list of movies

  As a user
  So that I can organize the movies
  I want to sort the movies by title or release date

Background: movies in database

  Given the following movies exist:
  | title        | rating | director     | release_date |
  | Star Wars    | PG     | George Lucas |   1977-05-25 |
  | Blade Runner | PG     | Ridley Scott |   1982-06-25 |
  | Alien        | R      |              |   1979-05-25 |
  | THX-1138     | R      | George Lucas |   1971-03-11 |

Scenario: sort by title
  When I am on the home page
  And I follow "title_header"
  Then I should see "Alien" followed by "Blade Runner"
  Then I should see "Blade Runner" followed by "Star Wars"
  Then I should see "Star Wars" followed by "THX-1138"

Scenario: sort by release date
  When I am on the home page
  And I follow "release_date_header"
  Then I should see "THX-1138" followed by "Star Wars"
  Then I should see "Star Wars" followed by "Alien"
  Then I should see "Alien" followed by "Blade Runner"