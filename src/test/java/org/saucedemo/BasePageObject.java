package org.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageObject {
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuBtn;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartBtn;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutBtn;
}