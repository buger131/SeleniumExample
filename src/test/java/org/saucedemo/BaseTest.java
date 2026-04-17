package org.saucedemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.saucedemo.extensions.BeforeEachExtension;

import java.time.Duration;

@ExtendWith(BeforeEachExtension.class)
public abstract class BaseTest {
    protected static WebDriver driver;

    private static final ChromeOptions options = new ChromeOptions();

    @BeforeEach
    public void setUp() {
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("guest");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        BasePage.setDriver(driver);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
//        Thread.sleep(10000);
        driver.close();
    }
}
