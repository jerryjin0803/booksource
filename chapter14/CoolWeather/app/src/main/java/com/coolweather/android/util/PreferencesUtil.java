package com.coolweather.android.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * 先简单实现。
 */
public class PreferencesUtil {
    //默认配置文件
    private static SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
    //自定义配置文件
    //final private static String preferencesName = "user";
    //private static SharedPreferences preferences = MyApplication.getContext().getSharedPreferences(preferencesName, Context.MODE_PRIVATE);

    /**
     * 写缓存
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    /**
     * 取缓存
     * @param key
     */
    public static String getString(String key) {
        return preferences.getString(key, null);
    }
}
