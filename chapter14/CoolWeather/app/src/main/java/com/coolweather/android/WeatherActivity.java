package com.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.coolweather.android.gson.Air;
import com.coolweather.android.gson.Forecast;
import com.coolweather.android.gson.Lifestyle;
import com.coolweather.android.gson.Now;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.service.AutoUpdateService;
import com.coolweather.android.util.HeweatherUtil;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.PreferencesUtil;
import com.coolweather.android.util.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;

    public SwipeRefreshLayout swipeRefresh;

    private ScrollView weatherLayout;

    private Button navButton;

    private TextView titleCity;

    private TextView titleUpdateTime;

    private TextView degreeText;

    private TextView weatherInfoText;

    private LinearLayout forecastLayout;

    private LinearLayout lifestyleLayout;

    private TextView aqiText;

    private TextView pm25Text;

    private ImageView bingPicImg;

    private ImageView weatherIco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        // --------------------- 初始化各控件 ------------------------
        // 基本信息
        bingPicImg = (ImageView) findViewById(R.id.bing_pic_img);//背景图
        weatherIco = (ImageView) findViewById(R.id.weather_ico);//天气图表
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);//天气滚动列表
        titleCity = (TextView) findViewById(R.id.title_city);//城市名
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);//更新时间
        degreeText = (TextView) findViewById(R.id.degree_text);//温度
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);//天气信息（风向风速等）
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);//预报列表
        // 空气质量
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        // 生活建议
        lifestyleLayout = (LinearLayout) findViewById(R.id.lifestyle_layout);//生活建议列表

        // 导航按钮
        navButton = (Button) findViewById(R.id.nav_button);

        // 下拉刷新
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // ---------------------- 绑定事件 ----------------------
        // 下拉刷新：取出缓存的 weatherId 请求数据
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestWeather(PreferencesUtil.getString("weatherId"));
            }
        });
        // 导航按钮:点击事件
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // ---------------------- 初始化显示 -----------------------
        // 取出缓存的天气信息，如果有直接解析并显示，否则去请求
        String weatherString = PreferencesUtil.getString("weather");
        if (weatherString != null) {
            Weather weather = Utility.handleWeatherResponse(weatherString);
            // 写缓存
            PreferencesUtil.putString("weatherId", weather.basic.getCid());
            showWeatherNow(weather);
        } else {
            // 无缓存时去服务器查询天气
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(getIntent().getStringExtra("weather_id"));
        }

        //String bingPic = prefs.getString("bing_pic", null);
        String bingPic = PreferencesUtil.getString("bing_pic");
        if (bingPic != null) {
            Glide.with(this).load(bingPic).into(bingPicImg);
        } else {
            loadBingPic();
        }
    }

    /**
     * 根据天气id请求城市天气信息。
     */
    public void requestWeather(final String weatherId) {
        String weatherUrl = String.format(HeweatherUtil.weather_url, weatherId, HeweatherUtil.key);
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.status)) {
                            // 取得天气JSON数据成功后先写缓存，方便下次调用。再更新UI显示
                            PreferencesUtil.putString("weather", responseText);
                            showWeatherNow(weather);
                            Toast.makeText(WeatherActivity.this, "天气信息已更新！", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                        }
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });
        loadBingPic();
    }

    /**
     * 加载必应每日一图
     */
    private void loadBingPic() {
        String requestBingPic = HeweatherUtil.bing_pic_url;
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
//                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
//                editor.putString("bing_pic", bingPic);
//                editor.apply();
                PreferencesUtil.putString("bing_pic", bingPic);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 处理并展示Weather实体类中的数据。
     */
    private void showWeatherNow(Weather weather) {
        showWeatherBaseInfo(weather);//当前的天气信息
        showWeatherForecast(weather.forecastList);//未来几天的预报
        showWeatherLifestyle(weather.lifestyleList);//显示生活指数
        weatherLayout.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);
    }

    /**
     * 空气质量
     */
    private void showWeatherAir(Air air) {
        //空气质量
        if (air.airNowCity != null) {
            aqiText.setText(air.airNowCity.getAqi()+"");//空气质量指数
            pm25Text.setText(air.airNowCity.getPm25()+"");//2.5微米的颗粒物 pm25
        }
    }

    /**
     * 当前的天气信息
     */
     private void showWeatherBaseInfo(Weather weather) {
        //基础信息
        String cityName = weather.basic.getLocation();
        String updateTime = weather.update.getLoc().split(" ")[1];
        Now now = weather.now;
        String degree = now.getTemperature() + "℃";
        String weatherInfo = now.getCondTxt() +"  "+ now.getWindDir() +"  "+ now.getWindSc() +"级";
        //String imgName = String.format("cond_icon_%d.png", now.getCondCode());
        //weatherIco.setImageResource(ResourcesUtils.getDrableId(this,imgName));
        Glide.with(WeatherActivity.this).load(String.format(HeweatherUtil.cond_icon_url, now.getCondCode() )).into(weatherIco);
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
    }

    /**
     * 显示空气质量
     */
    private void showWeatherForecast(List<Forecast> forecastList) {
        forecastLayout.removeAllViews();
        TextView titleText = (TextView)findViewById(R.id.forecast_title);

        titleText.setText("未来 "+ forecastList.size() +" 天预报");
        for (Forecast forecast : forecastList) {
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            dateText.setText(forecast.getDate());
            infoText.setText(forecast.getCondTxtD());
            maxText.setText(forecast.getTmpMax() + "℃");
            minText.setText(forecast.getTmpMin() + "℃");
            forecastLayout.addView(view);
        }
    }

    /**
     * 显示生活指数
     */
    private void showWeatherLifestyle(List<Lifestyle> lifestyleList){
        JSONObject lifestyleType = Utility.getLifestyleType();
        lifestyleLayout.removeAllViews();
        for (Lifestyle lifestyle : lifestyleList) {
            View view = LayoutInflater.from(this).inflate(R.layout.lifestyle_item, lifestyleLayout, false);
            TextView typeText = (TextView) view.findViewById(R.id.lifestyle_type);
            TextView brfText = (TextView) view.findViewById(R.id.lifestyle_brf);
            TextView txtText = (TextView) view.findViewById(R.id.lifestyle_txt);
            try {
                typeText.setText(lifestyleType.getString(lifestyle.getType()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            brfText.setText(lifestyle.getBrf());
            txtText.setText(lifestyle.getTxt());
            lifestyleLayout.addView(view);
        }
    }
}
