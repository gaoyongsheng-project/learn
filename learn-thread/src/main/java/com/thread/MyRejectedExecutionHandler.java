package com.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gys
 * @version 1.0
 * @date 2021/2/5 11:17
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("发生异常啦");
        //加上以下代码则为阻塞方式
        try {
            executor.getQueue().put(r); // 核心改造点，由blockingqueue的offer改成put阻塞方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}