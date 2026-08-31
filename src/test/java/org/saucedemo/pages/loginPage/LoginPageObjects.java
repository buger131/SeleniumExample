package org.saucedemo.pages.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
    @FindBy(id = "user-name")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;
}
