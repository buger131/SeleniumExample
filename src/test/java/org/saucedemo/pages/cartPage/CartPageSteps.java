package org.saucedemo.pages.cartPage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.saucedemo.BasePage;

@Slf4j
public class CartPageSteps extends BasePage<CartPageObjects> {

    public CartPageSteps() {
        super();
    }

    public CartPageSteps checkCartItem(String item) {
        object.cartItem.findElement(By.xpath(".//a//div[text()='"+ item +"']"));
        return this;
    }

    public CartPageSteps removeFromCart(String item) {
        object.cartItem.findElement(By.xpath(".//button[text()='Remove']")).click();
        return this;
    }

    public boolean checkEmptyCart() {
        try {
            object.cartItem.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
