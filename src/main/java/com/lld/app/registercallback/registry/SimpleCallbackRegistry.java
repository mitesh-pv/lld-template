package com.lld.app.registercallback.registry;

import com.lld.app.registercallback.client.ICallback;

/**
 * SimpleCallbackRegistry
 * Registers the callback function passed by the client
 * provides an execute method to execute pre-steps
 * Calls the callback passed by the client.
 */
public abstract class SimpleCallbackRegistry {
    public abstract void executeOperations();
    public void registerCallback(ICallback callback) {
        executeOperations();
        callback.callback();
    }
}
