package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.jdk.popcornstock_test.Intro.deviceId;
import static com.example.jdk.popcornstock_test.Intro.phoneNum;


public class Join extends Activity {

    EditText id_text, pw_text, pwOk_text, email_text, nick_text;
    TextView phone_text, deviceId_text;
    String str_id, str_pw, str_pwOk, str_email, str_nick, str_phone, str_deviceId;
    ImageButton register_btn, back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        id_text = (EditText) findViewById(R.id.id_editText);
        pw_text = (EditText) findViewById(R.id.pw_editText);
        pwOk_text = (EditText) findViewById(R.id.pwOk_editText);
        email_text = (EditText) findViewById(R.id.name_editText);
        nick_text = (EditText) findViewById(R.id.nick_editText);
        phone_text = (TextView) findViewById(R.id.phoneNum_text);
        deviceId_text = (TextView) findViewById(R.id.deviceId_text);

        register_btn = (ImageButton) findViewById(R.id.register_Btn);
        back_btn = (ImageButton) findViewById(R.id.back_btn);

        phone_text.setText(phoneNum);
        deviceId_text.setText(deviceId);

        pw_text.setTransformationMethod(PasswordTransformationMethod.getInstance());
        pwOk_text.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public void OnRegister(View v) {
        String str_id = id_text.getText().toString();
        String str_pw = pw_text.getText().toString();
        String str_email = email_text.getText().toString();
        String str_nick = nick_text.getText().toString();
        String str_phone = phone_text.getText().toString();
        String str_deviceId = deviceId_text.getText().toString();

        String method = "register";

        BackgroundJoin backgroundTask = new BackgroundJoin(this);
        backgroundTask.execute( method, str_id, str_pw, str_email, str_nick, str_phone, str_deviceId );
    }
}
