package com.example.hp.aha.activity.prefrence;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.hp.aha.activity.utils.AppConstants;


public class PreferenceManager {

    private static String serviceToken;

    private PreferenceManager() {
        super();
    }

    public static boolean containsInPref(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(key, 0);
        return prefs.contains(key);
    }

    public static void saveStringInPref(Context context, String key,
                                        String value) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringInPref(Context context, String key,
                                         String defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        return prefs.getString(key, defaultValue);
    }


    public static void saveIntegerInPref(Context context, String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntegerInPref(Context context, String key,
                                       int defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        return prefs.getInt(key, defaultValue);
    }

    public static void saveLongInPref(Context context, String key, long value) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static Long getLongInPref(Context context, String key,
                                     long defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        return prefs.getLong(key, defaultValue);
    }

    public static void saveBooleanInPref(Context context, String key,
                                         boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static Boolean getBooleanInPref(Context context, String key,
                                           boolean defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(
                AppConstants.SHARED_PREFS.SHARED_PREF_TITLE, 0);
        return prefs.getBoolean(key, defaultValue);
    }
}
