package com.coolweather.android.util;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * 程序的入口
 * Created by JerryJin on 2018-10-25.
 */

public class MyApplication extends Application {
    /**
     * 在这里把 context 保存下来，方便在任何地方获取上下文
     */
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}