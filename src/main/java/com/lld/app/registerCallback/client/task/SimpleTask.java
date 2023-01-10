package com.lld.app.registerCallback.client.task;

import com.lld.app.registerCallback.registry.SimpleCallbackRegistry;

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
