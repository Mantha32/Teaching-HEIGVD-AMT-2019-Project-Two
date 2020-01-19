@UpdateUserProfile
Feature: User update profile
  Users should be able to update his password

  Background: User logs in
    Given there is an UserApplication server
    And I login with following credentials
      | greg.bean@mockito.org | admin1234 |

  Scenario: Update user password
    Given I have an affective payload
    When I POST it to the /users endpoint
    Then I receive a 201 status code

