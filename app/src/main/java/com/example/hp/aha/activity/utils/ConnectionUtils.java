package com.example.hp.aha.activity.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

import com.example.hp.aha.R;


/**
 * This class is used to check the network availability.
 */
public class ConnectionUtils {
    /**
     * get Network connectivity status
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * show alert
     *
     * @param context
     */

    public static void alertMessage(Context context, String message) {
        new AlertDialog.Builder(context).setMessage(message)
                .setTitle(context.getResources().getString(R.string.app_name))
                .setCancelable(true)
                .setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        })
                .show();
    }


    /**
     * show alert
     *
     * @param context
     */

    public static void alertServerMessage(Context context, String message) {
        new AlertDialog.Builder(context).setMessage(message)
                .setTitle(context.getString(R.string.server_error))
                .setCancelable(true)
                .setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        })
                .show();
    }



}
