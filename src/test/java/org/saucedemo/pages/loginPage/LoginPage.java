package org.saucedemo.pages.loginPage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.BasePage;
import org.saucedemo.pages.productPage.ProductPage;

import static org.saucedemo.config.ConfigurationManager.config;
import static org.saucedemo.extensions.BeforeEachExtension.user;

@Slf4j
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage() {
        driver.get(config().baseUrl());
        PageFactory.initElements(driver, this);
        log.info("Инициализация элементов страницы входа...");
    }

    public ProductPage signIn() {
        userNameField.sendKeys(user.login());
        passwordField.sendKeys(user.password(), Keys.ENTER);
        return new ProductPage();
    }

    public LoginPage signInErr() {
        userNameField.sendKeys(user.login());
        passwordField.sendKeys(user.password(), Keys.ENTER);
        return this;
    }

    public void checkErrorMessage() {
        errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
