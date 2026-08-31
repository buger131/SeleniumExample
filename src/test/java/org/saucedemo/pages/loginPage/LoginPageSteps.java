package org.saucedemo.pages.loginPage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.saucedemo.BasePage;
import org.saucedemo.pages.productPage.ProductPageSteps;

import static org.saucedemo.extensions.BeforeEachExtension.user;

@Slf4j
public class LoginPageSteps extends BasePage<LoginPageObjects> {

    public LoginPageSteps() {
        super();
    }

    public ProductPageSteps signIn() {
        object.userNameField.sendKeys(user.login());
        object.passwordField.sendKeys(user.password(), Keys.ENTER);
        return BasePage.create(ProductPageSteps.class);
    }

    public LoginPageSteps signInErr() {
        object.userNameField.sendKeys(user.login());
        object.passwordField.sendKeys(user.password(), Keys.ENTER);
        return this;
    }

    public void checkErrorMessage() {
        object.errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return object.errorMessage.getText();
    }
}
