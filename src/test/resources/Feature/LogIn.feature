Feature: Login to orangehrm

Background:
Given user launches chrome browser

@smoke
Scenario: User logs in as valid user
     Given user Launches orangehrm website
     Then user logs in to the website as valid user
      And verify homePage layout

@smoke
Scenario: User logs in as Invalid user
     Given user Launches orangehrm website
     Then user logs in to the website as Invalid user
