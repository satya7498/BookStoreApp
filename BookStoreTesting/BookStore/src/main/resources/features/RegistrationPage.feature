Feature: Registration Form Page

  Scenario Outline: Succesfull Register
    Given open the browser
    When click on Register
    When Enter  username "<username>" ,email "<email>" ,password "<password>"
    When click the create account

    Examples: 
      | username | email             | password  |
      | william  | william@gmail.com | 123456789 |
      | nancy    | nancy@gmail.com   | nancy@123 |

  Scenario Outline: Unsuccessful Register
    Given user on the Login Page
    When click on Register link
    When Enter  username1 "<username1>" ,email1 "<email1>" ,password1 "<password1>"
    And user clicks Register button
    Then diplay register page

    Examples: 
      | username | email             | password  |
      |          | william@gmail.com | 123456789 |
      | nancy    |                   | nancy@123 |
      | john     | john@gmail.com    |           |
      | sam      |                   |           |
      |          |                   |   1234567 |
      |          |                   |           |