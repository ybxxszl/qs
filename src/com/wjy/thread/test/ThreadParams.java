package com.wjy.thread.test;

public class ThreadParams {

    public static final int COREPOOLSIZE = 10;
    public static final int MAXIMUMPOOLSIZE = 20;
    public static final long KEEPALIVETIME = 30;

    public static final String THREADGROUPNAME = "线程组";
    public static final String THREADNAME = "线程";

    public static long threadGroupNum = 1;
    public static long threadNum = 1;

    public static int getCorepoolsize() {
        return COREPOOLSIZE;
    }

    public static int getMaximumpoolsize() {
        return MAXIMUMPOOLSIZE;
    }

    public static long getKeepalivetime() {
        return KEEPALIVETIME;
    }

    public static String getThreadgroupname() {
        return THREADGROUPNAME;
    }

    public static String getThreadname() {
        return THREADNAME;
    }

    public static long getThreadGroupNum() {
        return threadGroupNum++;
    }

    public static long getThreadNum() {
        return threadNum++;
    }

}
