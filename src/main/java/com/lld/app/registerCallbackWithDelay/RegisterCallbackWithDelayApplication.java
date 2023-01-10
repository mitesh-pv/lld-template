package com.lld.app.registerCallbackWithDelay;

import com.lld.app.registerCallbackWithDelay.util.Callback;
import com.lld.app.registerCallbackWithDelay.util.CallbackExecutor;

public class RegisterCallbackWithDelayApplication {

    public void mainApplication() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Starting Time : " + System.currentTimeMillis()/1000);
        CallbackExecutor executor = new CallbackExecutor();
        executor.setEndTime(6);

        Thread executorThread = new Thread(() -> {
            try {
                executor.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorThread.setDaemon(true);
        executorThread.start();

        executor.registerCallback(new Callback(4, "Function 1"));
        executor.registerCallback(new Callback(8, "Function 2"));
        executor.registerCallback(new Callback(2, "Function 3"));

        executorThread.join();
    }
}
