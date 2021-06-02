Feature: BookList Form Page

  Background: login user
    Given open the browser to login
    When Enter  username "sara",password "123sara@123"
    And click the Login Button

  Scenario Outline: Check the Read Now Link Functionality
    Given on the BookPage
    When click on Read Now
    Then Verify the Book Name as "Seeing Theory"

  Scenario Outline: Check the add To Favorite Functionality
    Given on the Booklist Home Page
    When click on Add To Favorite FavButton
    When click on ok btn
    When click to Fav Section
    Then Verify book as "Seeing Theory"

  Scenario Outline: Check The Functionality of Search Bar
    When click on search btn for search
    When Enter the search text as "Seeing Theory" for search
    Then Verify Book name as "Seeing Theory" as search
