package com.lld;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

/**
 * DesignApplication
 */
public class DesignApplication {

    private static final String COMMON_PACKAGE_PREFIX = "com.lld.app.{0}";
    private static final String APP_MAIN_METHOD = "mainApplication";

    public static void main(String[] args) {
        String applicationName = MessageFormat.format(COMMON_PACKAGE_PREFIX, args[0]);

        System.out.println("============================== Starting  " + applicationName
                + " ==============================");

        try {
            final Class application = Class.forName(applicationName);
            final Object applicationInstance = application.getDeclaredConstructor().newInstance();
            application.getMethod(APP_MAIN_METHOD).invoke(applicationInstance);
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                | InstantiationException exp) {
            System.err.println(exp);
        }

        System.out.println("============================== Terminated ==============================");
    }
}
