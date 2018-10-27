package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 实况天气
 * 文档：https://www.heweather.com/documents/api/s6/weather-now
 * Created by JerryJin on 2018-10-16.
 */
public class Weather extends HeweatherBasic {
    @SerializedName("now")
    public Now now;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

    @SerializedName("lifestyle")
    public List<Lifestyle> lifestyleList;

}
