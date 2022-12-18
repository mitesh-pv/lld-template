package com.lld.app.registercallback;

import com.lld.app.registercallback.task.SimpleTask;

/**
 * A Class to register a callback function to the system which is invoked the end system itself.
 */
public class RegisterCallbackApplication {

    public void mainApplication() {
        SimpleTask task = new SimpleTask();
        task.registerCallback(() -> System.out.println("Callback function executing"));
    }
}