package com.lld.app.registercallback.task;

import com.lld.app.registercallback.registry.SimpleCallbackRegistry;

public class SimpleTask extends SimpleCallbackRegistry {
    @Override
    public void executeOperations() {
        System.out.println("This are the pre-callback operations that we want to perform");
    }
}
