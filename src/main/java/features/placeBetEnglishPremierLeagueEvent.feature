@smokeTest
Feature: Place a bet on a English Premier League event

  Scenario: As a WH Customer I want the ability to place a bet on a English Premier League even

    Given Navigate to "http://sports.williamhill.com/betting/en-gb"
    And Log in with "WHATA_FOG3" , "F0gUaTtest" user
    And Navigate to "http://sports.williamhill.com/betting/en-gb/football"
    And Select event for the "home" team to Win



