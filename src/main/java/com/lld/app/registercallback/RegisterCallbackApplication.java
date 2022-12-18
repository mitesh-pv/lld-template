package com.lld.app.registercallback;

import com.lld.app.registercallback.task.SimpleTask;
import lombok.extern.slf4j.Slf4j;

/**
 * A Class to register a callback function to the system which is invoked the end system itself.
 */
@Slf4j
public class RegisterCallbackApplication {

    public void mainApplication() {
        SimpleTask task = new SimpleTask();
        task.registerCallback(() -> log.info("Callback function executing"));
    }
}