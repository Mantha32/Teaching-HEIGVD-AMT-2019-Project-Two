Feature: Update an enrollment

  Background:
    Given there is a academic server

  Scenario: Update an enrollment with admin token
    Given I have a enrollment payload
    Given I have a admin token
    When I PATCH it to the /trips/1 endpoint
    Then I receive a 202 status code

