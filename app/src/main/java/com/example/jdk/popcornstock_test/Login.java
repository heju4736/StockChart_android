package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import static com.example.jdk.popcornstock_test.Intro.deviceId;


public class Login extends Activity {

    EditText id_text, pw_text;
    CheckBox id_check, pw_check;

    ImageButton joinBtn;
    LoginButton kakaoLogin_btn;

    TextView user_Code;
    String user_code;

    private SessionCallback callback;
    public SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_text = (EditText) findViewById(R.id.login_id);
        pw_text = (EditText) findViewById(R.id.login_pw);

        id_check = (CheckBox) findViewById(R.id.remember_id);
        pw_check = (CheckBox) findViewById(R.id.remember_pw);

        joinBtn = (ImageButton) findViewById(R.id.joinActivity_Btn);
        kakaoLogin_btn = (LoginButton) findViewById(R.id.com_kakao_login);



        user_Code = (TextView) findViewById(R.id.user_code);
        user_Code.setText(deviceId);

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Login.this, Join.class);
                startActivity( intent );
            }
        });

        //카카오톡
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
    }

    public void OnLogin( View view )
    {
        String userId = id_text.getText().toString();
        String userPw = pw_text.getText().toString();
        String user_code = user_Code.getText().toString();

        String type = "login";

        BackgroundLogin backgroundWorker = new BackgroundLogin(this);
        backgroundWorker.execute(type, userId, userPw, user_code);
    }

    public void onStop()
    {
        super.onStop();


        settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        id_text = (EditText) findViewById(R.id.login_id);
        pw_text = (EditText) findViewById(R.id.login_pw);

        id_check = (CheckBox) findViewById(R.id.remember_id);
        pw_check = (CheckBox) findViewById(R.id.remember_pw);

        //SharedPreferences에 각 아이디를 지정하고 EditText 내용을 저장한다.
        editor.putString("id_save", id_text.getText().toString());
        editor.putString("pwd_save", pw_text.getText().toString());
        editor.putBoolean("chk1", id_check.isChecked());
        editor.putBoolean("chk2", pw_check.isChecked());

        editor.commit();
    }


    //카카오톡
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data ) {
        if( Session.getCurrentSession().handleActivityResult( requestCode, resultCode, data ) )
        {
            return;
        }

        super.onActivityResult( requestCode, resultCode, data );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Session.getCurrentSession().removeCallback( callback );
    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {

            redirectSignupActivity();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {

            if( exception != null ) {
                Logger.e( exception );
            }

            setContentView( R.layout.activity_login );
        }
    }

    protected void redirectSignupActivity() {
        final Intent intent = new Intent(this, KakaoSignupActivity.class );
        intent.addFlags( Intent.FLAG_ACTIVITY_NO_ANIMATION );
        startActivity( intent );
        finish();
    }


}
