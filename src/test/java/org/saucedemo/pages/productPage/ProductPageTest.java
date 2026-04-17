package org.saucedemo.pages.productPage;

import org.junit.jupiter.api.Test;
import org.saucedemo.BaseTest;
import org.saucedemo.pages.loginPage.LoginPage;

public class ProductPageTest extends BaseTest {

    @Test
    public void checkOpen() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn().checkOpen();
    }

    @Test
    public void checkAddToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn().addToCart("Sauce Labs Backpack")
                .clickCart()
                .checkCartItem("Sauce Labs Backpack");
    }
}
