package com.wjy.thread.test1;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryCreate implements ThreadFactory {

    private static ThreadGroup group = new ThreadGroup(ThreadParams.THREADGROUPNAME + ThreadParams.getThreadGroupNum());

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(group, r, ThreadParams.THREADNAME + ThreadParams.getThreadNum());

        System.out.println(group.toString() + " --> " + thread.toString());

        return thread;

    }

}
