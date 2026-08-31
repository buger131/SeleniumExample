package org.saucedemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.saucedemo.extensions.BeforeEachExtension;
import org.saucedemo.extensions.DriverManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Duration;

import static org.saucedemo.config.ConfigurationManager.config;

@ExtendWith(BeforeEachExtension.class)
public abstract class BaseTest<T extends BasePage<?>> {
    protected static WebDriver driver;
    protected T page;

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

        driver.get(config().baseUrl());
        DriverManager.setDriver(driver);
        page = createPage();

    }

    @SuppressWarnings("unchecked")
    private T createPage() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<T> cl = (Class<T>) type;
        return BasePage.create(cl);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quit();
    }
}
