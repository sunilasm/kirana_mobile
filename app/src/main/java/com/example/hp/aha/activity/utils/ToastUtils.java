package com.example.hp.aha.activity.utils;


import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.aha.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Toast can be changed in entire application by just changing these methods
 */
public class ToastUtils {
    private static final String TAG = "ToastUtils";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Toast.LENGTH_LONG, Toast.LENGTH_SHORT})
    @interface Duration {
    }

    public static void shortToast(@NonNull Context context, @StringRes int stringResId) {
        shortToast(context, context != null ? context.getString(stringResId) : "");
//        showToast(context, msg, length == Toast.LENGTH_SHORT );

    }


    public static void shortToast(@NonNull Context context, String msg) {
//        showToast(context, msg, Toast.LENGTH_SHORT);
        showToast(context, msg, true);

    }

    public static void longToast(@NonNull Context context, String msg) {
//        showToast(context, msg, Toast.LENGTH_LONG);
        showToast(context, msg, false );

    }


    public static void showToast(@NonNull Context context, String msg, @Duration int length) {
        if (context != null) {
//            Toast.makeText(context, msg, length).show();
            showToast(context, msg, length == Toast.LENGTH_SHORT );
        } else {
//            Crashlytics.logException(new NullPointerException("context is null"));
        }
    }


    public static void showToast(Context context, String message, boolean isShort) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Getting the View object as defined in the customtoast.xml file
        View layout = inflater.inflate(R.layout.layout_custom_toast, null);
        TextView toastTextView = (TextView) layout.findViewById(android.R.id.message);
        toastTextView.setText(message);
        Toast toast = new Toast(context);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        if (!isShort) {
            toast.setDuration(Toast.LENGTH_LONG);
        } else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
