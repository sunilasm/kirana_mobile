package com.example.hp.aha.activity.application;

import android.app.Application;
import android.content.Context;

public class AHAApplication  extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }


    public static Context getAppContext() {
        return AHAApplication.context;
    }
}
