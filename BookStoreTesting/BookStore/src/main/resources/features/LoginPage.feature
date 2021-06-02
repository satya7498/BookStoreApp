Feature: Login Form Page

  Scenario Outline: Successfull Login
    Given open the Login Page in browser
    When Enter  credentials username2 "<username2>",password2 "<password2>"
    Then Click the Login Button

    Examples: 
      | username2 | password2   |
      | sara      | 123sara@123 |
      | satya     | satya@123   |

  Scenario Outline: UnSuccessfull Login
    Given Open The Login Page In Browser Window
    When Enter  Credentials As username3 "<username3>",password3 "<password3>"
    When Click The Login Button3
    Then Verify "Login"

    Examples: 
      | username2 | password2   |
      |           | 123sara@123 |
      | satya     |             |
      |           |             |
