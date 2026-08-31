package org.saucedemo.pages.cartPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageObjects {
    @FindBy(className = "cart_item")
    WebElement cartItem;
}
