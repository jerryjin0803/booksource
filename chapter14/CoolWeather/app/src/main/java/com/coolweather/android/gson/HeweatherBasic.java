package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 和风天气查询的基本信息，每个接口都会返回这些信息。
 * https://www.heweather.com/documents/search
 * Created by JerryJin on 2018-10-16.
 */
public class HeweatherBasic {
    /**
     * 接口文档
     * https://www.heweather.com/douments/api/s6/weather-forecast
     */
    public Basic basic;
    public Update update;
    public String status;// 接口状态

    /**
     * 基础信息(所查城市的位置详情和时区)
     */
    public class Basic {
        /**
         * 地区／城市名称（区县）
         */
        @SerializedName("location")
        private String location;
        /**
         * 地区／城市ID (用它来查天气)
         */
        @SerializedName("cid")
        private String cid;
        /**
         * 地区／城市纬度
         */
        private String lat;
        /**
         * 地区／城市经度
         */
        private String lon;
        /**
         * 该地区／城市的上级城市(市)
         */
        @SerializedName("parent_city")
        private String city;
        /**
         * 该地区／城市所属行政区域(省)
         */
        @SerializedName("admin_area")
        private String province;
        /**
         * 该地区／城市所属国家名称
         */
        @SerializedName("cnty")
        private String country;
        /**
         * 该地区／城市所在时区
         */
        @SerializedName("tz")
        private String timeZone;

        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
        public String getCid() {
            return cid;
        }
        public void setCid(String cid) {
            this.cid = cid;
        }
        public String getLat() {
            return lat;
        }
        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLon() {
            return lon;
        }
        public void setLon(String lon) {
            this.lon = lon;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getProvince() {
            return province;
        }
        public void setProvince(String province) {
            this.province = province;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public String getTimeZone() {
            return timeZone;
        }
        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }
    }

    /**
     * 数据更新的时间
     */
    public class Update{
        /**
         * 当地时间，24小时制，格式yyyy-MM-dd HH:mm    2017-10-25 12:34
         */
        @SerializedName("loc")
        private String loc;

        /**
         * UTC时间，24小时制，格式yyyy-MM-dd HH:mm      2017-10-25 04:34
         */
        @SerializedName("utc")
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }
}
