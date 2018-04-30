package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by Heeju on 2018-03-05.
 */

public class JongmokLoading extends Activity{

    ProgressBar loadingBar;

    Handler handler = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            Intent intent = new Intent(JongmokLoading.this, Bottombar.class );
            startActivity( intent );
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_bar2);

        loadingBar = (ProgressBar) findViewById(R.id.loadingBar2);

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
