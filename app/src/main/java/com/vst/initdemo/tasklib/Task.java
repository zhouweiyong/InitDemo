package com.vst.initdemo.tasklib;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/30
 * interface description:请输入接口描述
 */
public interface Task {

    void start();

    boolean runOnProgress(String progressName);

    void result();
}
