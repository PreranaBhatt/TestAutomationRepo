Feature: Verify hambergerMenu functionality

  Background:
    Given user launches chrome browser

  Scenario: open and shut functionality
    Given user Launches orangehrm website
    Then user logs in to the website as valid user
    When user tries to colapse hambergerMenu