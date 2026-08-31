package org.saucedemo.pages.productPage;

import org.junit.jupiter.api.Test;
import org.saucedemo.BaseTest;
import org.saucedemo.pages.loginPage.LoginPageSteps;

public class ProductPageTest extends BaseTest<ProductPageSteps> {

    @Test
    public void checkOpen() {
        LoginPageSteps loginPage = new LoginPageSteps();
        loginPage.signIn().checkOpen();
    }

    @Test
    public void checkAddToCart() throws InterruptedException {
        LoginPageSteps loginPage = new LoginPageSteps();
        loginPage.signIn().addToCart("Sauce Labs Backpack")
                .clickCart()
                .checkCartItem("Sauce Labs Backpack");
    }
}
