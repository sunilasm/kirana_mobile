package com.example.hp.aha.activity.prefrence;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;

/**
 * AppPref class is used for saving and getting the values in prefrence
 */

public class AppPrefs  {
    private static AppPrefs mAppPrefs;

    private AppPrefs(Context context) {
    }

    public static AppPrefs getInstance(Context context) {
        if (mAppPrefs == null)
            mAppPrefs = new AppPrefs(context);
        return mAppPrefs;
    }


    public void saveLoginStatus(Context context, boolean isSaved) {
        PreferenceManager.saveBooleanInPref(context, PrefKeys.Bool.IS_USER_LOGIN, isSaved);
    }

    public boolean getLoginStatus(Context context) {
        return PreferenceManager.getBooleanInPref(context, PrefKeys.Bool.IS_USER_LOGIN, false);
    }

    public void saveUserName(Context context, String username) {
        PreferenceManager.saveStringInPref(context, PrefKeys.Str.USER_NAME, username);
    }

    public String getUserName(Context context) {
        return PreferenceManager.getStringInPref(context, PrefKeys.Str.USER_NAME, "");
    }

    public void saveAccessToken(Context context, String accestoken) {
        PreferenceManager.saveStringInPref(context, PrefKeys.Str.ACCESS_TOKEN, accestoken);
    }

    public String getAccessToken(Context context) {
        return PreferenceManager.getStringInPref(context, PrefKeys.Str.ACCESS_TOKEN, "");
    }

}
