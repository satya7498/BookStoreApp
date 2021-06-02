Feature: Logout Form Page

  Scenario Outline:  Checking Logout Functionality
    Given on the login start page
    When Enter  user credentials username4 "<username4>",password4 "<password4>"
    When Click the Login Button4
    When Click the Logout Btn
    Then Verify with "Login"

    Examples: 
      | username4 | password4   |
      | sara      | 123sara@123 |
     