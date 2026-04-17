package org.saucedemo.pages.cartPage;

import org.junit.jupiter.api.Test;
import org.saucedemo.BaseTest;
import org.saucedemo.pages.loginPage.LoginPage;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CartPageTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        LoginPage loginPage = new LoginPage();
        CartPage cart = loginPage.signIn()
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .checkCartItem("Sauce Labs Backpack")
                .removeFromCart("Sauce Labs Backpack");
        assertFalse(cart.checkEmptyCart());
    }
}
