package org.saucedemo.pages.productPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageObjects {
    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "select_container")
    WebElement filterBtn;

    @FindBy(className = "inventory_list")
    WebElement inventoryList;
}
