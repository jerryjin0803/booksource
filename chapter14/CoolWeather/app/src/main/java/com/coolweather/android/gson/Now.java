package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 实况天气
 * 文档：https://www.heweather.com/documents/api/s6/weather-now
 * Created by JerryJin on 2018-10-16.
 */
public class Now {
    /**
     * 体感温度，默认单位：摄氏度
     */
    @SerializedName("fl")
    private int sendibleTemperature;
    /**
     * 温度，默认单位：摄氏度
     */
    @SerializedName("tmp")
    private int temperature;
    /**
     * 实况天气状况代码
     */
    @SerializedName("cond_code")
    private int condCode;
    /**
     * 实况天气状况描述
     */
    @SerializedName("cond_txt")
    private String condTxt;
    /**
     * 风向360角度
     */
    @SerializedName("wind_deg")
    private int windDeg;
    /**
     * 风向
     */
    @SerializedName("wind_dir")
    private String windDir;
    /**
     * 风力
     */
    @SerializedName("wind_sc")
    private int windSc;
    /**
     * 风速，公里/小时
     */
    @SerializedName("wind_spd")
    private int windSpd;
    /**
     * 相对湿度
     */
    private int hum;
    /**
     * 降水量
     */
    private int pcpn;
    /**
     * 大气压强
     */
    private int pres;
    /**
     * 能见度，默认单位：公里
     */
    private int vis;
    /**
     * 云量
     */
    private int cloud;

    public int getSendibleTemperature() {
        return sendibleTemperature;
    }

    public void setSendibleTemperature(int sendibleTemperature) {
        this.sendibleTemperature = sendibleTemperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCondCode() {
        return condCode;
    }

    public void setCondCode(int condCode) {
        this.condCode = condCode;
    }

    public String getCondTxt() {
        return condTxt;
    }

    public void setCondTxt(String condTxt) {
        this.condTxt = condTxt;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public int getWindSc() {
        return windSc;
    }

    public void setWindSc(int windSc) {
        this.windSc = windSc;
    }

    public int getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(int windSpd) {
        this.windSpd = windSpd;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public int getPcpn() {
        return pcpn;
    }

    public void setPcpn(int pcpn) {
        this.pcpn = pcpn;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public int getVis() {
        return vis;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }
}
