package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Viewpager4_3_2 extends Fragment {

    WebView webview;

    public static Viewpager4_3_2 newInstance() {
        return new Viewpager4_3_2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout4_4, container, false);

        webview = (WebView) view.findViewById(R.id.marketpower_webview);

        webview.loadUrl("http://61.72.187.6/phps/c1c2" );

        WebSettings webSettings = webview.getSettings();

        webview.setWebViewClient(new WebViewClient());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        webview.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        webview.onPause();
    }

}
