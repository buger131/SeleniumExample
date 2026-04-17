package org.saucedemo.extensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.saucedemo.annotations.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.saucedemo.config.ConfigurationManager.config;

@Slf4j
public class BeforeEachExtension implements BeforeEachCallback {
    public static User user;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        user = getCurrentUser(context);
        log.info("Вход под пользователем {}", user.login());
    }

    public User getCurrentUser(ExtensionContext context) {
        Method method = context.getRequiredTestMethod();
        Class<?> cl = context.getRequiredTestClass();

        log.info("Получение информации о пользователе...");

        if (AnnotationUtils.isAnnotated(method, User.class)) {
            return method.getAnnotation(User.class);
        } else if (AnnotationUtils.isAnnotated(cl, User.class)) {
            return cl.getAnnotation(User.class);
        } else {
            return new User() {
                @Override
                public Class<? extends Annotation> annotationType() {
                    return User.class;
                }

                @Override
                public String login() {
                    return config().defaultUsername();
                }

                @Override
                public String password() {
                    return config().defaultPassword();
                }
            };
        }
    }
}
