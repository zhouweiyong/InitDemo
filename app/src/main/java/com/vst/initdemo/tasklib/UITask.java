package com.vst.initdemo.tasklib;

import android.content.Context;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2017/1/3
 * class description:请输入类描述
 */
public abstract class UITask implements Task {
    private Context context;

    public UITask(Context context) {
        this.context = context;
    }

    @Override
    public void start() {
        initOnMainThread(context);
    }

    public abstract void initOnMainThread(Context context);

    @Override
    public boolean runOnProgress(String progressName) {
        return true;
    }

    @Override
    public void result() {

    }
}
