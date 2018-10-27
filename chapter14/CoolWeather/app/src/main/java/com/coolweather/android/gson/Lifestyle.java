package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 生活指数
 * https://www.heweather.com/documents/api/s6/weather
 * Created by JerryJin on 2018-10-16.
 */

public class Lifestyle {
    /**
     * 生活指数简介
     */
    @SerializedName("brf")
    private String brf;
    /**
     * 生活指数详细描述
     */
    @SerializedName("txt")
    private String txt;
    /**
     * 生活指数类型
     */
    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
