package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 空气质量实况 - AQI站点实况
 * https://www.heweather.com/documents/api/s6/air-now
 * Created by JerryJin on 2018-10-16.
 */

public class AirNowStation extends HeweatherBasic {

    /**
     * pub_time : 2017-11-07 22:00
     * air_sta : 万寿西宫
     * asid : CNA1001
     * lat : 39.8673
     * lon : 116.366
     * aqi : 19
     * main : -
     * qlty : 优
     * pm10 : 13
     * pm25 : 5
     * no2 : 37
     * so2 : 3
     * co : 0.4
     * o3 : 29
     */

    /**
     * 数据发布时间,格式yyyy-MM-dd HH:mm
     */
    @SerializedName("pub_time")
    private String pubTime;
    /**
     * 站点名称
     */
    @SerializedName("air_sta")
    private String airSta;
    /**
     * 站点ID，请参考所有站点ID
     * https://www.heweather.com/documents/city
     */
    @SerializedName("asid")
    private String asid;
    /**
     * 站点纬度
     */
    @SerializedName("lat")
    private double lat;
    /**
     * 站点经度
     */
    @SerializedName("lon")
    private double lon;
    /**
     * 空气质量指数，AQI和PM25的关系
     * https://www.heweather.com/blog/aqi
     */
    @SerializedName("aqi")
    private int aqi;
    /**
     * 主要污染物
     */
    @SerializedName("main")
    private String main;
    /**
     * 空气质量，取值范围:优，良，轻度污染，中度污染，重度污染，严重污染，查看计算方式
     * https://www.heweather.com/blog/aqi#qlty
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
    private double co;
    @SerializedName("o3")
    private int o3;

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getAirSta() {
        return airSta;
    }

    public void setAirSta(String airSta) {
        this.airSta = airSta;
    }

    public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getQlty() {
        return qlty;
    }

    public void setQlty(String qlty) {
        this.qlty = qlty;
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

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }
}
