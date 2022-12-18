package com.lld.app.registercallback.registry;

import com.lld.app.registercallback.client.ICallback;

public abstract class SimpleCallbackRegistry {
    public abstract void executeOperations();
    public void registerCallback(ICallback callback) {
        executeOperations();
        callback.callback();
    }
}
