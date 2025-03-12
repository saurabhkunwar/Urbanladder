 Feature: Checkout Managment
 Scenario: Proceed to checkout
    Given I have items in the cart
    When I proceed to checkout
    Then I should be redirected to the checkout page
    And the order summary should be displayed
