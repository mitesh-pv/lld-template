package com.lld.app.registerCallbackWithDelay.util;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallbackExecutor {
    private PriorityQueue<Callback> callbackQueue;
    private Lock lock;
    private Condition newCallbackRegistrationArrived;

    private long end;

    public void setEndTime(long endInSeconds) {
        this.end = System.currentTimeMillis() + (endInSeconds * 1000);
    }

    public CallbackExecutor() {
        this.callbackQueue = new PriorityQueue<>((o1, o2) -> (int) (o1.getExecuteAt() - o2.getExecuteAt()));
        this.lock = new ReentrantLock();
        this.newCallbackRegistrationArrived = lock.newCondition();
    }

    public void registerCallback(Callback callback) {
        lock.lock();
        callbackQueue.add(callback);
        newCallbackRegistrationArrived.signal();
        lock.unlock();
    }

    public void start() throws InterruptedException {
        long awaitTime;
        while (System.currentTimeMillis() < end) {
            System.out.println(System.currentTimeMillis()/1000 + " End: " + end/1000);
            lock.lock();

            while (callbackQueue.size() == 0) {
                newCallbackRegistrationArrived.await();
            }

            while (callbackQueue.size() != 0) {
                awaitTime = calculateAwaitTime();

                if (awaitTime <= 0) {
                    break;
                }

                newCallbackRegistrationArrived.await(awaitTime, TimeUnit.MILLISECONDS);
            }

            Callback callback = this.callbackQueue.poll();
            System.out.println(Thread.currentThread().getName() + " -> " + callback.getMessage() + " executed at " + callback.getExecuteAt()/1000);

            lock.unlock();
        }
    }

    private long calculateAwaitTime() {
        return this.callbackQueue.peek().getExecuteAt() - System.currentTimeMillis();
    }
}
