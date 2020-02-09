Feature: Get all my enrollment

  Background:
    Given there is a academic server

  Scenario: Get all my enrollment
    Given I have a user token
    When I GET a list of enrollment to the /enrollments endpoint with offset 0 and limit 3
    Then I receive a 200 status code

  Scenario: Get all enrollment
    Given I have a admin token
    When I GET a list of all enrollment to the /enrollments endpoint with offset 0 and limit 5
    Then I receive a 200 status code