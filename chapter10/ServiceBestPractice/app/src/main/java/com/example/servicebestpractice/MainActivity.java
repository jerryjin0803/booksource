package com.example.servicebestpractice;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 主活动（UI线程）工作如下：
 * 1、初始化 UI 界面，绑定按钮事件。
 * 2、实例化 ServiceConnection 通过他的 onServiceConnected 回调函数获取 service 的控制权
 * 3、动态申请权限
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DownloadService.DownloadBinder downloadBinder;

    /**
     * 绑定服务时 bindService方法的第二个参数
     */
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        /**
         * 由系统调用。DownloadService.onBind() 返回的 IBinder 会传到这里。就是 IBinder service
         * 然后活动中的按钮就可以通过 downloadBinder 控制服务中的逻辑了（下载的开始、暂停、取消）
         * @param name
         * @param service
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (DownloadService.DownloadBinder) service;
        }

    };

    /**
     * 1、初始化UI界面<br/>
     * 2、绑定按钮事件<br/>
     * 3、启动服务 + 绑定服务<br/>
     * 4、动态申请权限
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startDownload = (Button) findViewById(R.id.start_download);
        Button pauseDownload = (Button) findViewById(R.id.pause_download);
        Button cancelDownload = (Button) findViewById(R.id.cancel_download);
        startDownload.setOnClickListener(this);
        pauseDownload.setOnClickListener(this);
        cancelDownload.setOnClickListener(this);
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent); // 启动服务
        bindService(intent, connection, BIND_AUTO_CREATE); // 绑定服务
        // ----------- 动态申请权限 -----------
        // 如果有权限则返回PackageManager.PERMISSION_GRANTED，否则返回PackageManager.PERMISSION_DENIED
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        // 判断如果没有授权，则动态申请
        if ( permissionCheck != PackageManager.PERMISSION_GRANTED) {
            // 申请获取权限，弹出确认框等用户操作，然后会回调 onRequestPermissionsResult
            // 参数1：目标活动，MainActivity 弹框询问自然就传 MainActivity
            // 参数2：要申请的权限，放到数组里（就是说可以同时申请多个权限啦）
            // 参数3：请求码，就是暗号，不然回调怎么知道是哪个请求的结果返回来了（自己定，别和其他请求重复就行）
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
        }
    }

    /**
     * 定义三个按钮的点击事件回调。分别是：开始下载、暂停下载、取消下载
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (downloadBinder == null) {
            return;
        }
        switch (v.getId()) {
            case R.id.start_download:
                String url = "https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe";
                downloadBinder.startDownload(url);
                break;
            case R.id.pause_download:
                downloadBinder.pauseDownload();
                break;
            case R.id.cancel_download:
                downloadBinder.cancelDownload();
                break;
            default:
                break;
        }
    }

    /**
     * 用户选择授权与否，会回调这里
     * @param requestCode 这就是上面那个“请求码”
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();// 不授权，恕我无能为力，回见。
                }
                break;
            default:
        }
    }

    /**
     * 解绑服务 {@link DownloadListener}
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

}
