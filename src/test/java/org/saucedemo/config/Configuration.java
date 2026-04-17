package org.saucedemo.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:application.properties", "classpath:allure.properties"})
public interface Configuration extends Config {

    @Key("allure.results.directory")
    String allureDir();

    @Key("base.url")
    String baseUrl();

    @Key("default.username")
    String defaultUsername();

    @Key("default.password")
    String defaultPassword();
}
