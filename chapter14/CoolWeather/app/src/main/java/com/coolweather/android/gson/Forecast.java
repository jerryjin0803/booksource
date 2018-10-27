package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 3-10天天气预报
 * 文档：https://www.heweather.com/douments/api/s6/weather-forecast
 * Created by JerryJin on 2018-10-16.
 */
public class Forecast {
    /**
     * 预报日期
     */
    @SerializedName("date")
    private String date;
    /**
     * 日出时间
     */
    @SerializedName("sr")
    private String sr;
    /**
     * 日落时间
     */
    @SerializedName("ss")
    private String ss;
    /**
     * 月升时间
     */
    @SerializedName("mr")
    private String mr;
    /**
     * 月落时间
     */
    @SerializedName("ms")
    private String ms;
    /**
     * 最高温度
     */
    @SerializedName("tmp_max")
    private int tmpMax;
    /**
     * 最低温度
     */
    @SerializedName("tmp_min")
    private int tmpMin;
    /**
     * 白天天气状况代码
     */
    @SerializedName("cond_code_d")
    private int condCodeD;
    /**
     * 晚间天气状况代码
     */
    @SerializedName("cond_code_n")
    private int condCodeN;
    /**
     * 白天天气状况描述
     */
    @SerializedName("cond_txt_d")
    private String condTxtD;
    /**
     * 晚间天气状况描述
     */
    @SerializedName("cond_txt_n")
    private String condTxtN;
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
    private String windSc;
    /**
     * 风速，公里/小时
     */
    @SerializedName("wind_spd")
    private int windSpd;
    /**
     * 	相对湿度
     */
    @SerializedName("hum")
    private int hum;
    /**
     * 降水量
     */
    @SerializedName("pcpn")
    private double pcpn;
    /**
     * 降水概率
     */
    @SerializedName("pop")
    private int pop;
    /**
     * 大气压强
     */
    @SerializedName("pres")
    private int pres;
    /**
     * 紫外线强度指数
     */
    @SerializedName("uv_index")
    private int uvIndex;
    /**
     * 能见度，单位：公里
     */
    @SerializedName("vis")
    private int vis;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public int getTmpMax() {
        return tmpMax;
    }

    public void setTmpMax(int tmpMax) {
        this.tmpMax = tmpMax;
    }

    public int getTmpMin() {
        return tmpMin;
    }

    public void setTmpMin(int tmpMin) {
        this.tmpMin = tmpMin;
    }

    public int getCondCodeD() {
        return condCodeD;
    }

    public void setCondCodeD(int condCodeD) {
        this.condCodeD = condCodeD;
    }

    public int getCondCodeN() {
        return condCodeN;
    }

    public void setCondCodeN(int condCodeN) {
        this.condCodeN = condCodeN;
    }

    public String getCondTxtD() {
        return condTxtD;
    }

    public void setCondTxtD(String condTxtD) {
        this.condTxtD = condTxtD;
    }

    public String getCondTxtN() {
        return condTxtN;
    }

    public void setCondTxtN(String condTxtN) {
        this.condTxtN = condTxtN;
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

    public String getWindSc() {
        return windSc;
    }

    public void setWindSc(String windSc) {
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

    public double getPcpn() {
        return pcpn;
    }

    public void setPcpn(double pcpn) {
        this.pcpn = pcpn;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public int getVis() {
        return vis;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }
}