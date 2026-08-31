package org.saucedemo.pages.loginPage;

import org.junit.jupiter.api.Test;
import org.saucedemo.BaseTest;
import org.saucedemo.annotations.User;
import org.saucedemo.pages.productPage.ProductPageSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest extends BaseTest<LoginPageSteps> {

    @Test
    public void testSuccessfulLogin() {
        ProductPageSteps product = page.signIn();
        assertThat(product.getTitle().equals("Products"));
    }

    @Test
    @User(login = "locked_out_user")
    public void testLoginErr() {
        page.signInErr().checkErrorMessage();
        assertThat(page.getErrorMessage().equals("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    public void testLogOut() {
        page.signIn().logOut();
    }
}
