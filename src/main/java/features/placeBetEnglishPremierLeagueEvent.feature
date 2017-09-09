@smokeTest
Feature: Place a bet on a English Premier League event

  Scenario: As a WH Customer I want the ability to place a bet on a English Premier League even

    Given Navigate to "http://sports.williamhill.com/betting/en-gb"
    And Log in with user "WHATA_FOG3" and password "F0gUaTtest"
    And Navigate to "http://sports.williamhill.com/betting/en-gb/football"
    And Select event for the "Home" team to Win
    And Place "0.05" bet and assert the odds and returns offered
