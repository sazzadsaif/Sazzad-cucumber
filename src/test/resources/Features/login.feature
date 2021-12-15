@Login_test
Feature: Test login functionalities

  Background:
    Given a user in on the login page

  @positive_test
  Scenario: Check login is successful with valid credentials

    When user enters user name "Sazzad" and password "12345"
    And click on login button
    Then user is navigated to home page
  @dataDriven_test @positive_test
  Scenario Outline: Check login is successful with valid credentials for multiple users

    When user enters user name "<username>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
      |username|password|
      |Sazzad  |12345   |
      |Fahmi   |12345   |
      |Aamer   |12345   |
  @dataDriven_test @positive_test
    Scenario: Check login is successful using data table

      When user click on login button upon entering credentials
        |username|password|
        |Sazzad  |12345   |
      Then user is navigated to home page
  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials

    When user enters user name "Sazzad" and password "44444"
    And click on login button
    Then user is failed to login

