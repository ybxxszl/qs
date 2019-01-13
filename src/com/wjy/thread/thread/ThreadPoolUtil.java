package com.wjy.thread;

import java.util.concurrent.*;

public class ThreadPoolUtil {

    private static ThreadFactoryCreate create = new ThreadFactoryCreate();
    private static ThreadRejectedExecutionHandler handler = new ThreadRejectedExecutionHandler();

    /*
     * @int corePoolSize 核心线程数，即使处于闲置状态也不会受到keepAliveTime影响
     *
     * @int maximumPoolSize 线程池最大线程数
     *
     * @long keepAliveTime 非核心线程闲置超时时间
     *
     * @TimeUnit unit 指定keepAliveTime的单位
     *
     * @SynchronousQueue<Runnable>/LinkedBlockingDeque<Runnable>/
     * ArrayBlockingQueue<Runnable> workQueue 指定线程池中的任务队列
     *
     * @ThreadFactory threadFactory 线程工厂，创建新线程
     *
     * @RejectedExecutionHandler handler
     * 线程池中的线程全部被使用，添加新线程被拒绝时，调用RejectedExecutionHandler的rejectedExecution
     */

    private static ThreadPoolExecutor executor_SynchronousQueue = new ThreadPoolExecutor(ThreadParams.COREPOOLSIZE,
            ThreadParams.MAXIMUMPOOLSIZE, ThreadParams.KEEPALIVETIME, TimeUnit.SECONDS, new SynchronousQueue<>(),
            create, handler);
    private static ThreadPoolExecutor executor_LinkedBlockingDeque = new ThreadPoolExecutor(ThreadParams.COREPOOLSIZE,
            ThreadParams.MAXIMUMPOOLSIZE, ThreadParams.KEEPALIVETIME, TimeUnit.SECONDS,
            new LinkedBlockingDeque<Runnable>(), create, handler);
    private static ThreadPoolExecutor executor_ArrayBlockingQueue = new ThreadPoolExecutor(ThreadParams.COREPOOLSIZE,
            ThreadParams.MAXIMUMPOOLSIZE, ThreadParams.KEEPALIVETIME, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1), create, handler);

    public static ThreadPoolExecutor getExecutor_SynchronousQueue() {
        return executor_SynchronousQueue;
    }

    public static ThreadPoolExecutor getExecutor_LinkedBlockingDeque() {
        return executor_LinkedBlockingDeque;
    }

    public static ThreadPoolExecutor getExecutor_ArrayBlockingQueue() {
        return executor_ArrayBlockingQueue;
    }

}
