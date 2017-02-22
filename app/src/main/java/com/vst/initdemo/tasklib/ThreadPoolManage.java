package com.vst.initdemo.tasklib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2017/1/3
 * class description:请输入类描述
 */
public class ThreadPoolManage {
    private static final int DEFAULT_THREAD_POOL_SIZE = 8;
    private static ExecutorService pool;
    private static int mThreadPoolSize = DEFAULT_THREAD_POOL_SIZE;

    public static ExecutorService getThreadPool(){
        if (pool==null){
            createThreadPool();
        }
        return pool;
    }

    private static void createThreadPool(){
        if (mThreadPoolSize<=0){
            pool = Executors.newCachedThreadPool();
        }else {
            pool = Executors.newFixedThreadPool(mThreadPoolSize);
        }
    }

    public static void setmThreadPoolSize(int threadPoolSize) {
        if (mThreadPoolSize!=threadPoolSize){
            mThreadPoolSize = threadPoolSize;
            createThreadPool();
        }
    }

    public static void releaseThreadPool(){
        pool=null;
    }
}
