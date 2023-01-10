package com.lld.app.registerCallback;

import com.lld.app.registerCallback.client.task.SimpleTask;
import lombok.extern.slf4j.Slf4j;

/**
 * Low Level Design
 * Create a Callback registry class to register your own callback function.
 * Implement that registry class to pass your callback function which performs set of operations and calls the callback function thereafter.
 */
@Slf4j
public class RegisterCallbackApplication {

    public void mainApplication() {
        SimpleTask task = new SimpleTask();
        task.registerCallback(() -> System.out.println("Callback function executing"));
    }
}