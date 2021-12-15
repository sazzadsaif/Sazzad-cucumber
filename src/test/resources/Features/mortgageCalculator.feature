Feature: Mortgage Calculator
  @CalculateApr
  Scenario: Calculate Real APR Rate
    Given user is in mortgage calculator home page
    And user navigate to Real APR page
    When user click on calculate button upon entering data
    |HomePrice|DownPayment|InterestRate|Year|
    |200000   |15000      |3           |30  |
    Then the Real APR rate is "3.130%"