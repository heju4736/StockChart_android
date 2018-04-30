package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.jdk.popcornstock_test.Bottombar.code;


public class Viewpager1_4 extends Fragment {

    public static Viewpager1_4 newInstance() {
        return new Viewpager1_4();
    }

    static WebView news_webview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listview1_4item, container, false);

        news_webview = (WebView) view.findViewById(R.id.news_webview);
        news_webview.loadUrl( "https://newscrolling-sungheeek.c9users.io/crolling.html?companycode=" + code );

        WebSettings webSettings = news_webview.getSettings();
        news_webview.setWebViewClient(new WebViewClient());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        news_webview.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        news_webview.onPause();
    }
}
