Feature: Get list of all salle

  Background:
    Given there is an academic server

  Scenario:  Get list of all salle
    When I GET a list of all available salle to the /salles endpoint
    Then I receive a 200 status code