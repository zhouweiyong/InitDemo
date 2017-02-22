package com.vst.initdemo.tasklib;


/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/30
 * class description:请输入类描述
 */
public abstract class ThreadTask implements Task, Runnable {


    @Override
    public boolean runOnProgress(String progressName) {
        return true;
    }

    @Override
    public void result() {

    }

    @Override
    public void run() {
        try {
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
