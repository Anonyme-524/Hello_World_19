package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class AliActivity extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.nine_tail_fox),Toast.LENGTH_SHORT).show();
        //Toast，弹出式通知
        //makeText()，构建通知，三个参数(Context，字符串资源，时长)
        //getApplicationContext()，获取当前Context
        //Context，上下文
        //show()，显示出来
        //getResources().getString(),获取资源，获取字符串资源（资源ID）
    }
}
