package org.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageObject {
    @FindBy(id = "react-burger-menu-btn")
    public static WebElement burgerMenuBtn;

    @FindBy(id = "shopping_cart_container")
    public static WebElement cartBtn;

    public static class BurgerMenu {
        @FindBy(id = "logout_sidebar_link")
        public static WebElement logOutBtn;
    }
}