package com.vst.initdemo.tasklib;

import android.app.ActivityManager;
import android.content.Context;
import android.util.SparseArray;

import java.util.concurrent.ExecutorService;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/30
 * class description:请输入类描述
 */
public class TaskManage {

    private SparseArray<Task> tasks;
    private Context context;

    public TaskManage(Context context) {
        this.context = context;
        tasks = new SparseArray<>();
    }

    public void addTask(Task task) {
        tasks.put(tasks.size(), task);
    }

    public void execute(){
        int l = tasks.size();
        for (int i = 0; i < l; i++) {
            Task task = tasks.get(i);
            if (task.runOnProgress(getCurrProcName())){
                if (task instanceof ThreadTask){
                    ExecutorService pool = ThreadPoolManage.getThreadPool();
                    pool.submit((ThreadTask)task);
                }else {
                    task.start();
                }
            }
        }
    }

    private String getCurrProcName() {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

}
