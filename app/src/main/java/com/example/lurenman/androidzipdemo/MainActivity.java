package com.example.lurenman.androidzipdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lurenman.androidzipdemo.utils.ZipUtils;

import java.io.File;
import java.io.IOException;

/**
 * 压缩文件路径自己改
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String mSdFileAbsolutePath = SMApp.getContext().getExternalFilesDir(null).getAbsolutePath();
    private TextView tv_src_zip;
    private TextView tv_des_zip;
    private TextView tv_src_upzip;
    private TextView tv_des_upzip;
    private Button bt_zip;
    private Button bt_upzip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initViews() {
        tv_src_zip = (TextView) findViewById(R.id.tv_src_zip);
        tv_des_zip = (TextView) findViewById(R.id.tv_des_zip);
        tv_src_upzip = (TextView) findViewById(R.id.tv_src_upzip);
        tv_des_upzip = (TextView) findViewById(R.id.tv_des_upzip);
        bt_zip = (Button) findViewById(R.id.bt_zip);
        bt_upzip = (Button) findViewById(R.id.bt_upzip);

        tv_src_zip.setText("压缩原路径："+mSdFileAbsolutePath+"/in.mp4");
        tv_des_zip.setText("压缩目标路径："+mSdFileAbsolutePath+"/in.zip");

        tv_src_upzip.setText("解压缩原路径："+mSdFileAbsolutePath+"/in.zip");
        tv_des_upzip.setText("解压缩目标路径："+mSdFileAbsolutePath+"/upzip/in.mp4");
    }

    private void initEvents() {
       bt_zip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   Log.e(TAG, "onClick: zip start----------");
                   ZipUtils.zip(mSdFileAbsolutePath+"/in.mp4",mSdFileAbsolutePath+"/in.zip");
                   //ZipUtils.Gzip(new File(mSdFileAbsolutePath+"/in.mp4"),new File(mSdFileAbsolutePath+"/in.zip"));
                   Log.e(TAG, "onClick: zip finish ----------");
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });
       bt_upzip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   Log.e(TAG, "onClick: upzip start----------");
                  ZipUtils.unzip(mSdFileAbsolutePath+"/in.zip",mSdFileAbsolutePath+"/upzip");
                   //ZipUtils.GunZip(new File(mSdFileAbsolutePath+"/in.zip"),new File(mSdFileAbsolutePath+"/upzip"));
                   Log.e(TAG, "onClick: upzip finish ----------");
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });
    }
}
