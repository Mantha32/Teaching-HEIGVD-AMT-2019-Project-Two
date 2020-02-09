Feature: Creation of enrollment

  Background:
    Given there is an academic server

  Scenario: create an enrollment
    Given I have an enrollment payload
    Given I have an admin token
    When I POST it to the /enrollments endpoint with my admin token
    Then I receive a 201 status code

  Scenario: create a trips
    Given I have an enrollment payload
    Given I have an user token
    When I POST it to the /enrollments endpoint with my user token
    Then I receive a 201 status code