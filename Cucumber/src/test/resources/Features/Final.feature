Feature: testing orangHRM functionality

@test1
 Scenario: navigation to solution-people managment-HR admin
    Given I open Url "https://www.orangeHRM.com"
	When I move mouse on "Solutions"
    When I move mouse on "People Management"
  #  When I move mouse on "HR Administrator"
   #Then I verify the url "https://www.orangehrm.com/en/solutions/people-management/hr-administration/"
#
    #
#
  #@test2
  #Scenario Outline: navigation flow for people mamangement tab
    #Given I open Url "https://www.orangeHRM.com"
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
#
      #
      #
 #@Test3
  #Scenario: Solution > People Management > HR Admin
    #Given I open Url "https://www.orangehrm.com/"
    #When I move mouse on "Solutions"
    #And I move mouse on "People Management"
    #And I move mouse on "HR Administration"
    #Then I navigate to "HR Administration"
    #And I verify Page Url "https://www.orangehrm.com/en/solutions/people-management/hr-administration/"