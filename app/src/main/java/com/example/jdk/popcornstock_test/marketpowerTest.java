package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Heeju on 2018-02-23.
 */

public class marketpowerTest extends Activity {

    WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4_4);

        webview = (WebView) findViewById(R.id.marketpower_webview);

        webview.loadUrl("http://61.72.187.6/attn/c1chart/index" );

        WebSettings webSettings = webview.getSettings();

        webview.setWebViewClient(new WebViewClient());


    }

    @Override
    protected void onResume() {
        super.onResume();
        webview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webview.onPause();
    }

}
