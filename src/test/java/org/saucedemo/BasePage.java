package org.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.extensions.DriverManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BasePage<T> {
    protected WebDriver driver;
    protected T object;
    protected BasePageObject header;

    public BasePage() {
        this.object = createPageObjects();
        this.driver = DriverManager.getDriver();
        this.header = new BasePageObject();
        PageFactory.initElements(driver, this.object);
        PageFactory.initElements(driver, this.header);
    }

    @SuppressWarnings("unchecked")
    private T createPageObjects() {
        try {
            Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Class<T> cl = (Class<T>) type;
            return cl.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Не удалось создать объекты страницы", e);
        }
    }

    public static <P extends BasePage<?>> P create(Class<P> pageClass) {
        try {
//            Constructor<P> constructor = pageClass.getConstructor(WebDriver.class);
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Не удалось создать страницу" + pageClass, e);
        }
    }
}
