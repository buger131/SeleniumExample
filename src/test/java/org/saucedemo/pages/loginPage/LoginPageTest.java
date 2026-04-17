package org.saucedemo.pages.loginPage;

import org.junit.jupiter.api.Test;
import org.saucedemo.BaseTest;
import org.saucedemo.annotations.User;
import org.saucedemo.pages.productPage.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage();
        ProductPage product = loginPage.signIn();
        assertThat(product.getTitle().equals("Products"));
    }

    @Test
    @User(login = "locked_out_user")
    public void testLoginErr() {
        LoginPage loginPage = new LoginPage();
        loginPage.signInErr().checkErrorMessage();
        assertThat(loginPage.getErrorMessage().equals("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    public void testLogOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn().logOut();
    }
}
