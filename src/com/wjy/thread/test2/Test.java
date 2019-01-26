package com.wjy.thread.test2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Test {

    /**
     * 固定线程数，支持定时和周期性任务
     */
    static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10);

    public static void main(String[] args) {

        TimeRunnable r = new TimeRunnable();

        // pool.schedule(r, 10, TimeUnit.SECONDS);

        pool.scheduleWithFixedDelay(r, 5, 10, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(r, 5, 10, TimeUnit.SECONDS);

    }

}
