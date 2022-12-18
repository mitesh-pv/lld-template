package com.lld.app.registercallback.client.task;

import com.lld.app.registercallback.registry.SimpleCallbackRegistry;

/**
 * SimpleTask
 * This class extends registry class to execute the pre-callback steps.
 */
public class SimpleTask extends SimpleCallbackRegistry {
    @Override
    public void executeOperations() {
        System.out.println("Executing pre-callback functions steps");
    }
}
