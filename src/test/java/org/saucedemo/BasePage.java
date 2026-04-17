package org.saucedemo;

import lombok.Setter;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    @Setter
    protected static WebDriver driver;
}
