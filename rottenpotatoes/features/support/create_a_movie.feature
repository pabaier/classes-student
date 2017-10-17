Feature: create a movie

  As an owner
  So that I can grow the app
  I want to add a movie to the database

Background: movies in database

  Given the following movies exist:
  | title        | rating | director     | release_date |
  | Star Wars    | PG     | George Lucas |   1977-05-25 |
  | Blade Runner | PG     | Ridley Scott |   1982-06-25 |
  | Alien        | R      |              |   1979-05-25 |
  | THX-1138     | R      | George Lucas |   1971-03-11 |

Scenario: add add new movie link to home page
  When I am on the home page
  Then I should see "Add new movie"

Scenario: add new movie
  Given I am on the add new movie page
  And I fill in "movie_title" with "Moana"
  And I select "G" from "movie_rating"
  And I select "2016" from "movie_release_date_1i"
  And I select "November" from "movie_release_date_2i"
  And I select "23" from "movie_release_date_3i"
  And I press "Save Changes"
  Then I should be on the home page
  And I should see "Moana G 2016-11-23"