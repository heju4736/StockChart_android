package com.example.jdk.popcornstock_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.androidquery.AQuery;

import static com.example.jdk.popcornstock_test.KakaoSignupActivity.kakaoImgExpand;

public class Img_Expand extends AppCompatActivity {

    ImageButton profile_close;
    ImageView img_expand;
    AQuery aQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img__expand);

        img_expand = (ImageView) findViewById(R.id.img_expand);
        profile_close = (ImageButton) findViewById(R.id.profile_close);


        aQuery = new AQuery( this );
        aQuery.id( img_expand ).image( kakaoImgExpand );

        profile_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
