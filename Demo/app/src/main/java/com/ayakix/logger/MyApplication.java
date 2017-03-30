package com.ayakix.logger;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by Ayakix on 2017/03/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init(getString(R.string.app_name)).logAdapter(new MyLogAdapter());
    }
}
