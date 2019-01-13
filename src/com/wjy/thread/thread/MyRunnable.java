package com.wjy.thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {

        try {

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " running");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
