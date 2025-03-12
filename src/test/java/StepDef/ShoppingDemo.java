package StepDef;

import org.junit.Assert;
import Utility.Base1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingDemo {
    public static Base1 base;
    Page1 page = new Page1();

    @Given("I am on the OpenCart homepage")
    public void i_am_on_the_open_cart_homepage() {
        base.driver.get("https://demo.opencart.com.gr/");
        System.out.println("Navigating to the Homepage");
    }

    @When("I search for a product {string}")
    public void i_search_for_a_product(String productName) {
        page.Search(productName);
        System.out.println("Searching for product: " + productName);
    }

    @Then("I should see the product {string} in search results")
    public void i_should_see_the_product_in_search_results(String productName) {
        boolean visible = page.Visible();
        Assert.assertTrue("Product is not visible", visible);
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        page.add_to_cart();
    }

    @Then("I should see the product {string} in the cart")
    public void i_should_see_the_product_in_the_cart(String productName) {
        Assert.assertTrue("Product not in cart", page.checkCart());
    }

    @When("I proceed to checkout and complete the payment")
    public void i_proceed_to_checkout_and_complete_the_payment() {
        page.Checkout();
    }

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String message) {
        page.Payment();
    }
}
