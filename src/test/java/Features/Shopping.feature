Feature: OpenCart Product Purchase

  Scenario: Successfully purchase a product
    Given I am on the OpenCart homepage
    When I search for a product "MacBook"
    Then I should see the product "MacBook" in search results
    When I add the product to the cart
    Then I should see the product "MacBook" in the cart
    When I proceed to checkout and complete the payment
    Then I should see a message "Successfully Product Purchased"
