package com.vst.initdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vst.initdemo.tasklib.TaskManage;
import com.vst.initdemo.tasklib.ThreadTask;
import com.vst.initdemo.tasklib.UITask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                TaskManage taskManage = new TaskManage(this);
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
                UITask task2 = new UITask(this) {
                    @Override
                    public void initOnMainThread(Context context) {
                        Log.i("zwy", "UITask:" + Thread.currentThread().getId() + ">>" + Thread.currentThread().getName());
                    }
                };
                taskManage.addTask(task2);
                taskManage.execute();
                break;
        }
    }
}
