package com.wjy.thread.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    /**
     * 固定线程数线程池，包含一定数量线程的线程池
     */
    static ExecutorService pool1 = Executors.newFixedThreadPool(10);

    /**
     * 单线程池，只用一个线程来执行任务，任务一个一个顺序执行
     */
    static ExecutorService pool2 = Executors.newSingleThreadExecutor();

    /**
     * 缓存线程池，适用于生命周期短的任务
     */
    static ExecutorService pool3 = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            MyRunnable r = new MyRunnable();

            pool1.submit(r);

        }

        for (int i = 1; i <= 10; i++) {

            MyRunnable r = new MyRunnable();

            pool2.submit(r);

        }

        for (int i = 1; i <= 10; i++) {

            MyRunnable r = new MyRunnable();

            pool3.submit(r);

        }

    }

}
