package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



public class KakaoSignupActivity extends Activity {

    static String kakaoId = "";
    static String kakaoNickname = "";
    static String kakaoEmail = "";
    static String kakaoProfile = "";
    static String kakaoImgExpand = "";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestMe();
    }

    //유저의 정보를 받아오는 func
    protected void requestMe() {
        UserManagement.requestMe(new MeResponseCallback() {

            @Override
            public void onFailure(ErrorResult errorResult) {
                String message = "failed to get user info. msg = " + errorResult;
                Logger.d(message);

                ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());

                if (result == ErrorCode.CLIENT_ERROR_CODE) {
                    finish();
                } else {
                    redirectLoginActivity();
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                redirectLoginActivity();
            }

            @Override
            public void onNotSignedUp() {

            }

            @Override
            public void onSuccess(UserProfile userProfile) {

                kakaoId = String.valueOf(userProfile.getId());
                kakaoNickname = String.valueOf(userProfile.getNickname());
                kakaoProfile = String.valueOf(userProfile.getThumbnailImagePath());
                kakaoImgExpand = String.valueOf(userProfile.getProfileImagePath());
                kakaoEmail = String.valueOf(userProfile.getEmail());

                Logger.d("UserProfile : " + userProfile);
                Log.d("kakao", "==========================");
                Log.d("kakao", "" + userProfile);
                Log.d("kakao", kakaoId);
                Log.d("kakao", kakaoNickname);
                Log.d("kakao", kakaoEmail);
                Log.d("kakao", kakaoProfile);
                Log.d("kakao", "==========================");

                Intent intent = new Intent( KakaoSignupActivity.this, LoadingBar.class);
                startActivity( intent );

            }
        });
    }


    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}

