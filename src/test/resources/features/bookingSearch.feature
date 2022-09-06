Feature: Booking search
  Background:
    Given pre condition
  Scenario Outline: Search is a hotel Minsk Marriott Hotel
    Given Hotel for search is "<searchWord>"
    When I navigate to www.booking.com
    And I enter a search name
    And  I press search button hotel
    Then There is a hotel with this name
    Examples:
      |searchWord|
      |Minsk Marriott Hotel|
      |Victoria & SPA Minsk|
  Scenario Outline: Check hotel rating
    Given Hotel for search is "<searchWord>"
    When I navigate to www.booking.com
    And I enter a search name
    And  I press search button hotel
    Then There are "<rating>" results are present
    Examples:
      |searchWord| |rating|
      |Minsk Marriott Hotel| |8.8|
      |Victoria & SPA Minsk| |8.4|
