package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 空气质量实况 - AQI城市实况
 * https://www.heweather.com/documents/api/s6/air-now
 * Created by JerryJin on 2018-10-16.
 */

public class AirNowCity extends HeweatherBasic {

    /**
     * 数据发布时间,格式yyyy-MM-dd HH:mm
     */
    @SerializedName("pub_time")
    private String pubTime;
    /**
     * 空气质量指数，AQI和PM25的关系
     */
    @SerializedName("aqi")
    private int aqi;
    /**
     * 主要污染物
     */
    @SerializedName("main")
    private String main;
    /**
     * \空气质量，取值范围:优，良，轻度污染，中度污染，重度污染，严重污染，查看计算方式
     */
    @SerializedName("qlty")
    private String qlty;

    @SerializedName("pm10")
    private int pm10;
    @SerializedName("pm25")
    private int pm25;
    @SerializedName("no2")
    private int no2;
    @SerializedName("so2")
    private int so2;
    @SerializedName("co")
    private int co;
    @SerializedName("o3")
    private int o3;

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getQlty() {
        return qlty;
    }

    public void setQlty(String qlty) {
        this.qlty = qlty;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }
}
