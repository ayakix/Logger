package com.ayakix.logger;

import android.util.Log;

import com.orhanobut.logger.LogAdapter;

/**
 * Created by Ayakix on 2017/03/30.
 */

public class MyLogAdapter implements LogAdapter {
    @Override
    public void v(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message);
        }
    }

    @Override
    public void d(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    @Override
    public void i(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }

    @Override
    public void w(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, message);
        }
    }

    @Override
    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void wtf(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.wtf(tag, message);
        }
    }
}
