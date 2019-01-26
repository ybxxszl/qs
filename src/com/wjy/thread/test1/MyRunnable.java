package com.wjy.thread.test1;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

    @Override
    public void run() {

        try {

            long l = (long) (Math.random() * 10 + 1);

            TimeUnit.SECONDS.sleep(l);

            System.out.println(Thread.currentThread().getName() + " running " + l);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
