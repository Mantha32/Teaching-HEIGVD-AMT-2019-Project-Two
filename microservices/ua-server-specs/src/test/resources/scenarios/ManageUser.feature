Feature: Testing a user REST API
  Only administrator can create users and get all the userlist

  Background:
    Given there is an UserApplication server
    And a global administrator named "Greg"



  Scenario: record a user
    Given I have an affective payload
    And I am logged in as Greg
    When I POST it to the /users endpoint
    Then I receive a 201 status code

  Scenario: Greg get list of users
    Given I am logged in as Greg
    When I do a GET on the /users endpoint
    Then I receive a 200 status code
    And the payload is a non-empty list

  Scenario: Greg delete on user out of 4 users
    Given I am logged in as Greg
    When Greg delete one user on the /users endpoint
    Then I receive a 201 status code

