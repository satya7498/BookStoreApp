Feature: Favorite Form Page

      
Background: login user with credentials
  Given move to login page
    When Enter  username5 "sara",password5 "123sara@123" 
    And click  on the Login Buttonf
    
    Scenario Outline: Check the remove from Favorite Functionality
    Given move to Favorite Page
    When click on remove Btnf
    