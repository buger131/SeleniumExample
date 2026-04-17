package org.saucedemo.pages.productPage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.BasePage;
import org.saucedemo.BasePageObject;
import org.saucedemo.pages.cartPage.CartPage;

import static org.saucedemo.BasePageObject.BurgerMenu.*;
import static org.saucedemo.BasePageObject.burgerMenuBtn;
import static org.saucedemo.BasePageObject.cartBtn;

@Slf4j
public class ProductPage extends BasePage {
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "select_container")
    private WebElement filterBtn;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    public ProductPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, BasePageObject.class);
        PageFactory.initElements(driver, BasePageObject.BurgerMenu.class);
        log.info("Инициализация элементов продуктовой страницы...");
    }

    public void logOut() {
        burgerMenuBtn.isDisplayed();
        burgerMenuBtn.click();
        logOutBtn.isDisplayed();
        logOutBtn.click();
    }

    public void checkOpen() {
        pageTitle.isDisplayed();
        filterBtn.isDisplayed();
        inventoryList.isDisplayed();
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public ProductPage addToCart(String item) {
        inventoryList.findElement(By.xpath(".//div[text()='"+ item +"']" +
                "//ancestor-or-self::div[@class='inventory_item_label']" +
                "//following-sibling::div[@class='pricebar']" +
                "//button")).click();
        return this;
    }

    public CartPage clickCart() {
        cartBtn.isDisplayed();
        cartBtn.click();
        return new CartPage();
    }
}
