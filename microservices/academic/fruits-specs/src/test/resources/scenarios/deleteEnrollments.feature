Feature: Delete an enrollment by id

  Background:
    Given there is an academic server



  Scenario: Delete an enrollment by id with admin token
    Given I have an enrollment payload
    Given I have a admin token
    Given I POST it to the /enrollments endpoint with my admin token
    When I DELETE it to the /enrollments/idEnrollment endpoint with my admin token
    Then I receive a 204 status code
    And I deleted successfully an enrollment

  Scenario: Delete an enrollment by id with user token
    Given I have an enrollment payload
    Given I have a user token
    Given I POST it to the /enrollments endpoint with my user token
    When I DELETE it to the /enrollments/idEnrollment endpoint with my user token
    Then I receive a 204 status code
    And I deleted successfully an enrollment

