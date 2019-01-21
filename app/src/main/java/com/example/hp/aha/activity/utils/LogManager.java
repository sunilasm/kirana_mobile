package com.example.hp.aha.activity.utils;

import android.content.Context;
import android.util.Log;


public class LogManager {
    public static final String FTL_LOG = "FTL_LOG";
    public static boolean isDebugToBeLogged = true;
    static Context context;

    private LogManager() {
        super();
    }

    public static void d(String tag, String message) {
        if (isDebugToBeLogged == true) {
            if (message == null) {
                return;
            }
            Log.d(tag, message);
        } else {
            // do nothing
        }
    }

    public static void e(String tag, String message) {
        e(null, tag, message);
    }

    public static void e(Context ctx, String tag, String message) {
        if (isDebugToBeLogged == true) {
            Log.e(tag, message);
        } else {
            // do nothing
        }
    }

    public static void v(Context ctx, String tag, String message) {
        if (isDebugToBeLogged == true) {
            Log.v(tag, message);
        } else {
            // do nothing
        }
    }

    public static void i(Context ctx, String tag, String message) {
        if (isDebugToBeLogged == true) {
            Log.i(tag, message);
        } else {
            // do nothing
        }
    }

    public static void w(Context ctx, String tag, String message) {
        if (isDebugToBeLogged == true) {
            Log.w(tag, message);
        } else {
            // do nothing
        }
    }

    /*
     *Method used to print stacktrace
	 */
    public static void printStackTrace(Throwable e) {
        if (e != null) {
            e.printStackTrace();

           // ExceptionHandleActivity.switchToScreen(context, e.toString());

        }
    }


}
