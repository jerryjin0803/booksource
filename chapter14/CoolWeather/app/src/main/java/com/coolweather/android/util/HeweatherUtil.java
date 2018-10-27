package com.coolweather.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.bumptech.glide.Glide;
import com.coolweather.android.WeatherActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 和风天气工具类
 * Created by Administrator on 2018-10-16.
 */

public class HeweatherUtil {
    public final static String key = "abc7f0fa0ec945918ddc175fe7761ec4";
    public final static String weather_url = "https://free-api.heweather.com/s6/weather?location=%s&key=%s";
    public final static String air_url = "https://free-api.heweather.com/s6/air?location=%s&key=%s";
    public final static String bing_pic_url = "http://guolin.tech/api/bing_pic";
    public final static String cond_icon_url = "https://cdn.heweather.com/cond_icon/%d.png";
}
