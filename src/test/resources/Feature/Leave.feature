Feature: Verify Admin/User Management page

  Background:
    Given user launches chrome browser
    Given user Launches orangehrm website
    Then user logs in to the website as valid user
    And User on hamberger menu section clicks on search bar
    And User on hamberger menu section enter text Leave
#
#  Scenario:Verify Leave page top headings
#    Then User on Leave page verify PageHeading

  Scenario: User check his leave list for vacation
    Then User on leave page selects from-Date
    And User on Leave page selects to-date
    Then User on leave page select leave with status as Scheduled type
    And User on Leave page selects leave type as CAN - Vacation
    Then User click on SearchButton
    Then User on Leave page verify record at search result