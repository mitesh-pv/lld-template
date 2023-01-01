package com.lld.app.registerCallbackWithDelay.util;

public class Callback {
    private long executeAt;
    private String message;

    public Callback(int executeAfterInSecs, String message) {
        this.message = message;
        this.executeAt = System.currentTimeMillis() + (executeAfterInSecs * 1000);
    }

    public long getExecuteAt() {
        return executeAt;
    }

    public String getMessage() {
        return message;
    }
}
