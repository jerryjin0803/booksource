package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 空气质量数据集合
 * https://www.heweather.com/documents/api/s6/air-all
 * Created by JerryJin on 2018-10-16.
 */
public class Air extends HeweatherBasic {
    @SerializedName("air_now_city")
    public AirNowCity airNowCity ;

    @SerializedName("air_now_station")
    public List<AirNowStation > airNowStationList ;
}
