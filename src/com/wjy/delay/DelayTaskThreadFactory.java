package com.wjy.delay;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayTaskThreadFactory implements ThreadFactory {

	private ThreadGroup group;

	private AtomicInteger poolNumber = new AtomicInteger(0);
	private AtomicInteger threadNumber = new AtomicInteger(0);

	private String name;

	public DelayTaskThreadFactory(String poolName) {

		group = Thread.currentThread().getThreadGroup();

		name = poolName + " - " + poolNumber.incrementAndGet();

	}

	@Override
	public Thread newThread(Runnable r) {

		Thread thread = new Thread(group, r, name + " : " + threadNumber.incrementAndGet(), 0);

		return thread;

	}

}
