Feature: Booking search
  Scenario: Search is a hotel Виктория Спа Минск
    Given Hotel for search is "Виктория Спа Минск"
    When I navigate to www.booking.com
    And I enter a search name
    And  I press search button hotel
    Then There is a hotel with this name
  Scenario: Check hotel rating
    Given Hotel for search is "Виктория Спа Минск"
    When I navigate to www.booking.com
    And I enter a search name
    And  I press search button hotel
    Then There are "8.4" results are present