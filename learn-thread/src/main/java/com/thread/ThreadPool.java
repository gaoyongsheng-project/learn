package com.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gys
 * @version 1.0
 * @date 2021/2/5 11:15
 */
public class ThreadPool {

    private static ThreadPoolExecutor threadPoolExecutor = null;

    public static ThreadPoolExecutor getExecutor() {
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        /**
         * 线程池初始化方法
         *
         * corePoolSize 核心线程池大小----10
         * maximumPoolSize 最大线程池大小----30
         * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
         * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
         * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)====10容量的阻塞队列
         * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
         * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
         *                          即当提交第41个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
         *                                任务会交给RejectedExecutionHandler来处理
         */
        return new ThreadPoolExecutor(10, 30, 30, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(10), new MyThreadFactory(), new MyRejectedExecutionHandler());
    }

    public static void destory() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPool.getExecutor();
        for (int i = 1; i < 100; i++) {
            System.out.println("当前提交第" + i + "个任务!---》阻塞队列有线程了，队列中阻塞的线程数量:"+ threadPoolExecutor.getQueue().size()+"---》活跃的线程数量:"+ threadPoolExecutor.getActiveCount());
            threadPoolExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了
        // exec.destory();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
