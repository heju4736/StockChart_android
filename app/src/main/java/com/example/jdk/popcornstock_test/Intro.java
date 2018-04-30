package com.example.jdk.popcornstock_test;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Intro extends AndroidPermission {

    TextView testText;
    private static final int REQUEST_PERMISSION = 10;
    static String phoneNum = "";
    static String deviceId = "";

    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //통화상태, 사진, 파일 접근
        requestAppPermission(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                R.string.msg, REQUEST_PERMISSION);
    }


    @Override
    public void onPermissionGranted(int requestCode) {

        ///TODO 권한체크

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if ( ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED )
        {
            return;
        }
        phoneNum = telephonyManager.getLine1Number();
        deviceId = telephonyManager.getDeviceId();

        //Toast.makeText( getApplicationContext(), phoneNum, Toast.LENGTH_SHORT).show();
        //Toast.makeText( getApplicationContext(), deviceId, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {

        super.onResume();
        handler.postDelayed(r, 2000);
    }

    @Override
    protected void onPause() {

        super.onPause();
        handler.removeCallbacks(r);
    }
}
