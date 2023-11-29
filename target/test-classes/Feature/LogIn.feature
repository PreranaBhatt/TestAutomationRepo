Feature: Login to orangehrm

Background:
Given user launches chrome browser

@smoke
Scenario: Title of your scenario
    Given user Lauches orangehrm website
    Then user quit browser
  				 				
@smoke
Scenario: User logs in as valid user
     Given user Lauches orangehrm website
     Then user logs in to the website as valid user
     Then user quit browser
     
@smoke
Scenario: User logs in as Invalid user
     Given user Lauches orangehrm website
     Then user logs in to the website as Invalid user
     Then user quit browser