Feature: Shopping Cart Management

 Scenario: Update item quantity in the cart
    Given I have an item in the cart
    When I update the quantity to "4"
    Then the cart should reflect the updated quantity
    And the total price should be updated accordingly
    
  Scenario: Remove an item from the cart
    Given I have an item in the cart
    When I remove the item from the cart
    Then the cart should be empty

 