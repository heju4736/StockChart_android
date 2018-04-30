package com.example.jdk.popcornstock_test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.jdk.popcornstock_test.Intro.deviceId;
import static com.example.jdk.popcornstock_test.Intro.phoneNum;
import static com.example.jdk.popcornstock_test.KakaoSignupActivity.kakaoEmail;
import static com.example.jdk.popcornstock_test.KakaoSignupActivity.kakaoId;
import static com.example.jdk.popcornstock_test.KakaoSignupActivity.kakaoNickname;


public class LoadingBar extends AppCompatActivity {

    ProgressBar loadingBar;
    TextView kakao_Id, kakao_Nick, kakao_Email, device_Id, phone_Num;

    Handler handler = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            Intent intent = new Intent(LoadingBar.this, Bottombar.class );
            startActivity( intent );
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_bar);

        loadingBar = (ProgressBar) findViewById(R.id.loadingBar);

        kakao_Id = (TextView) findViewById(R.id.kakaoId_text);
        kakao_Id.setText(kakaoId);

        kakao_Nick = (TextView) findViewById(R.id.kakaoNick_text);
        kakao_Nick.setText(kakaoNickname);

        kakao_Email = (TextView) findViewById(R.id.kakaoEmail_text);
        kakao_Email.setText(kakaoEmail);

        device_Id = (TextView) findViewById(R.id.deviceId_text);
        device_Id.setText(deviceId);

        phone_Num = (TextView) findViewById(R.id.phoneNum_text);
        phone_Num.setText(phoneNum);

        String str_id = kakao_Id.getText().toString();
        String str_nick = kakao_Nick.getText().toString();
        String str_email = kakao_Email.getText().toString();
        String str_deviceId = device_Id.getText().toString();
        String str_phoneNum = phone_Num.getText().toString();

        String method = "kakaoLogin";

        BackgroundKakao backgroundKakao = new BackgroundKakao(this);
        backgroundKakao.execute( method, str_id, str_nick, str_email, str_deviceId, str_phoneNum );
    }

    @Override
    protected void onResume() {

        super.onResume();
        handler.postDelayed( r, 300 );
    }

    @Override
    protected void onPause() {

        super.onPause();
        handler.removeCallbacks(r);
    }
}
