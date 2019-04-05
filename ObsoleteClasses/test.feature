#@FeatureFileName
#Feature: Incorrect username and password login attempt tp Phalanx
#  I want to verify that when I attempt login to Phalanx using incorrect username and password
#
#  Scenario Outline: Navigate to phalanx's login page and attempt login using incorrect username and password
#    Given I navigate to the phalanx url in "<browserName>"
#    When login page is displayed
#    And insert incorrect username and password
#    And click on the 'Login'button
#    Then confirm when the error message is displayed to the user
#
#    Examples: 
#      | browserName |
#      | chrome |
#