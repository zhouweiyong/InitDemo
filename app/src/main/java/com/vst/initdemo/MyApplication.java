package com.vst.initdemo;

import android.app.Application;

import com.vst.initdemo.tasklib.AppInit;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/29
 * class description:请输入类描述
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppInit.start(this,5000);
    }
}
