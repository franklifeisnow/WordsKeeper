package com.franklee.wordskeeper.base;

import android.app.Application;

import com.franklee.wordskeeper.BuildConfig;

import org.xutils.x;

/**
 * Created by Lijinpeng on 2016/11/2.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        x.Ext.init(this);
//        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
