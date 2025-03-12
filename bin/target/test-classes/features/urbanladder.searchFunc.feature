Feature: Search Functionality
  As a user
  I want to search for products on Urban Ladder
  So that I can filter them by new arrivals, price, and ratings

  Background:
    Given the user is on the home page
    
@search
  Scenario Outline: Search for a product and apply filters
    When the user searches for "<product>"
    Then the search results should be displayed

    When the user applies the "<filter_type>" filter
    Then only "<expected_result>" should be shown

    When the user filters by price range "<price_range>"
    Then only products within the price range should be shown

    When the user filters by "<rating>" rating
    Then only products with "<rating>" ratings and above should be shown

  Examples:
    | product  | filter_type     | expected_result    | price_range       | rating          |
    | Sofa     | New Arrivals    | newly arrived     | ₹10,000 - ₹20,000 | 4-star and above |
  
