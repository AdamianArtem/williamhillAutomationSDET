@smokeTest
Feature: As a WH Customer I want to be able to search for specific game on Vegas Casino and login to the webpage


  Scenario: As a WH Customer I want to be able to search for specific game on Vegas Casino


    Given Navigate to "https://vegas.williamhill.com/"
    And In the top-right corner click magnifier button
    Then Search for "Mayfair Roulette" game
    And Hover over the "Mayfair Roulette" game tile and click "More" button
    Then Click "Play Now" and validate Login window is displayed


  Scenario: As a WH Customer I want to be able to login to the webpage


    Given Navigate to "https://vegas.williamhill.com/"
    And Log in with user "WHATA_FOG3" and password "F0gUaTtest"