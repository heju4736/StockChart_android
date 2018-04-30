package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.example.jdk.popcornstock_test.Viewpager2_2.goldegg;
import static com.example.jdk.popcornstock_test.Viewpager2_2.strperfomance;
import static com.example.jdk.popcornstock_test.Viewpager2_2.strpower;
import static com.example.jdk.popcornstock_test.Viewpager2_2.strsupply;
import static com.example.jdk.popcornstock_test.Viewpager2_2.value;


public class Viewpager2_1 extends Fragment {

    WebView webView;

    public Viewpager2_1()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.activity_viewpager2_1, container, false);

        webView = (WebView) view.findViewById(R.id.webview);
        webView.loadUrl("http://61.72.187.6/attn/stockevent/index?gold=" + goldegg + "&power=" + strpower + "&supply=" + strsupply + "&performance=" + strperfomance + "&value=" + value);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        return view; 
    }

    public static Viewpager2_1 newInstance() {
        return new Viewpager2_1();
    }
}
