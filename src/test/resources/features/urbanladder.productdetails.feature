@ProductDetails
Feature: Product Details Page

  Background: 
    Given I am on the search result page

  Scenario: Validate product details
    When I click on a product
    Then I should see the product title
    And I should see the product description
    And I should see the product price
    And I should see the product availability status
    
    

  Scenario: Add product to wishlist
    When I click on the  Add to Wishlist button
    Then the product should be added to my wishlist
    

  Scenario: Add product to cart
    When I click on the Add to Cart button
    Then the product should be added to my cart
