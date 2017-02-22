package com.vst.initdemo.tasklib;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/30
 * class description:请输入类描述
 */
public class AppInit {

    public static void start(Application application, long delay) {
        TaskManage taskManage = new TaskManage(application);
        ThreadTask task1 = new ThreadTask() {
            @Override
            public void start() {
                Log.i("zwy", "ThreadTask:" + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            }

            @Override
            public boolean runOnProgress(String progressName) {
                return progressName.equals("com.vst.initdemo");
            }
        };
        taskManage.addTask(task1);
        UITask task2 = new UITask(application) {
            @Override
            public void initOnMainThread(Context context) {
                Log.i("zwy", "UITask:" + Thread.currentThread().getId() + ">>" + Thread.currentThread().getName());
            }
        };
        taskManage.addTask(task2);
        final TaskManage taskManage2 = taskManage;
//        taskManage.execute();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                taskManage2.execute();
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(timerTask, delay);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                taskManage2.execute();
            }
        },delay);
    }
}
