package com.wjy.thread.test;

import java.util.concurrent.ThreadPoolExecutor;

public class Test {

    public static void main(String[] args) {

        try {

            test(ThreadPoolUtil.getExecutor_ArrayBlockingQueue());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static void test(ThreadPoolExecutor executor) throws Exception {

        MyRunnable runnable = new MyRunnable();

        for (int i = 1; i <= 15; i++) {
            executor.execute(runnable);
        }

        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池中线程数" + executor.getPoolSize());
        System.out.println("队列中任务数" + executor.getQueue().size());

        for (int i = 1; i <= 25; i++) {
            executor.execute(runnable);
        }

        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池中线程数" + executor.getPoolSize());
        System.out.println("队列中任务数" + executor.getQueue().size());

        Thread.sleep(30000);

        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());

    }

}
