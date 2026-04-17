package org.saucedemo.pages.cartPage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.BasePage;
import org.saucedemo.BasePageObject;

@Slf4j
public class CartPage extends BasePage {
    @FindBy(className = "cart_item")
    private WebElement cartItem;

    public CartPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, BasePageObject.class);
        PageFactory.initElements(driver, BasePageObject.BurgerMenu.class);
        log.info("Инициализация элементов продуктовой страницы...");
    }

    public CartPage checkCartItem(String item) {
        cartItem.findElement(By.xpath(".//a//div[text()='"+ item +"']"));
        return this;
    }

    public CartPage removeFromCart(String item) {
        cartItem.findElement(By.xpath(".//button[text()='Remove']")).click();
        return this;
    }

    public boolean checkEmptyCart() {
        try {
            cartItem.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
