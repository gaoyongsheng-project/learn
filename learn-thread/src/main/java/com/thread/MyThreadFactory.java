package com.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gys
 * @version 1.0
 * @date 2021/2/5 11:20
 */
public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger count = new AtomicInteger(0);
    private final String className = MyThreadFactory.class.getSimpleName();

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(className + this.count.getAndAdd(1));
        System.out.println(String.format("Thread name = %s", thread.getName()));
        return thread;
    }
}