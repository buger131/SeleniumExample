package org.saucedemo.pages.productPage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.saucedemo.BasePage;
import org.saucedemo.pages.cartPage.CartPageSteps;

@Slf4j
public class ProductPageSteps extends BasePage<ProductPageObjects> {

    public ProductPageSteps() {
        super();
    }

    public void logOut() {
        header.burgerMenuBtn.isDisplayed();
        header.burgerMenuBtn.click();
        header.logOutBtn.isDisplayed();
        header.logOutBtn.click();
    }

    public void checkOpen() {
        object.pageTitle.isDisplayed();
        object.filterBtn.isDisplayed();
        object.inventoryList.isDisplayed();
    }

    public String getTitle() {
        return object.pageTitle.getText();
    }

    public ProductPageSteps addToCart(String item) {
        object.inventoryList.findElement(By.xpath(".//div[text()='"+ item +"']" +
                "//ancestor-or-self::div[@class='inventory_item_label']" +
                "//following-sibling::div[@class='pricebar']" +
                "//button")).click();
        return this;
    }

    public CartPageSteps clickCart() {
        header.cartBtn.isDisplayed();
        header.cartBtn.click();
        return BasePage.create(CartPageSteps.class);
    }
}
