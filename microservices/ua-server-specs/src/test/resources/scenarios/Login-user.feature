Feature: Testing login user
  As an application user
  I want to login my user profile using my credentials
  Only administrator gets all the user list
  In order to access to the enrollment

  Background:
    Given there is an UserApplication server
    And a global administrator named "Greg"

  Scenario: login to application as user
    Given I login with following credentials
      | john.do@mockito.org | pass1234 |
    When I POST it to the /users/login endpoint
    Then I receive a 201 status code

  Scenario: login to application as admin
    Given I login with following credentials
      | greg.bean@mockito.org | admin1234 |
    When I POST it to the /users/login endpoint
    Then I receive a 200 status code

  Scenario: login to application as admin
    Given I login with following credentials
      | greg.bean@mockito.org | admin1234 |
    When I POST it to the /users/login endpoint
    Then I receive a 200 status code

  Scenario Outline: login to application as admin
    Given I login with following credentials
      | greg.bean@mockito.org | wrong1234 |
    When I POST it to the /users/login endpoint
    Then I receive a 200 status code
    And I should see "<warning>" message

    Examples:
      | email             | password   | warning                           |
      | test@test.org     | !23        | Incorrect credentials. Try again! |
      | test@test.org     |            | Incorrect credentials. Try again! |
      | test@t            | !23        | Incorrect credentials. Try again! |