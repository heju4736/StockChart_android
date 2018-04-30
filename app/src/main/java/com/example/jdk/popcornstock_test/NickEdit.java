package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.jdk.popcornstock_test.Fragment5.str_nick;
import static com.example.jdk.popcornstock_test.Intro.phoneNum;


public class NickEdit extends Activity {

    ImageButton back_btn, delete_btn;
    Button nickOk_btn;
    TextView nick_hp;
    EditText nickEdit_edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_edit);


        nick_hp = (TextView) findViewById(R.id.nick_hp);
        nick_hp.setText(phoneNum);

        back_btn = (ImageButton) findViewById(R.id.nickBack_btn);
        delete_btn = (ImageButton) findViewById(R.id.nickDelete_Btn);
        nickEdit_edit = (EditText) findViewById(R.id.nickEdit_text);
        nickOk_btn = (Button) findViewById(R.id.nickOk_Btn);

        nickEdit_edit.setHint(str_nick);

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nickEdit_edit.setText(null);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment5 fragment5 = new Fragment5();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace( R.id.nickedit_frag, fragment5 );
                fragmentTransaction.commit();

            }
        });


    }

    public void OnNickSet(View v) {
        String str_id = nickEdit_edit.getText().toString();
        String str_pw = nick_hp.getText().toString();

        String method = "nickSet";

        BackgroundNickSet backgroundTask = new BackgroundNickSet(this);
        backgroundTask.execute( method, str_id, str_pw );

        Fragment5 fragment5 = new Fragment5();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.nickedit_frag, fragment5 );
        fragmentTransaction.commit();

    }


}
