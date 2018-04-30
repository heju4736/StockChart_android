package com.example.jdk.popcornstock_test;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import org.json.JSONException;


import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.jdk.popcornstock_test.Bottombar.clearHistory;
import static com.example.jdk.popcornstock_test.Bottombar.code;
import static com.example.jdk.popcornstock_test.Bottombar.jsonObject;
import static com.example.jdk.popcornstock_test.Bottombar.str_now;
import static com.example.jdk.popcornstock_test.Bottombar.str_per;
import static com.example.jdk.popcornstock_test.Bottombar.str_pok;
import static com.example.jdk.popcornstock_test.Bottombar.str_semo;

public class Viewpager1_1 extends Fragment {

    static WebView chart_webView;

    TextView jongmok_code, text1, text2, text3, text4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_viewpager1_1, container, false);


        jongmok_code = (TextView) view.findViewById(R.id.jongmok_text1);
        text1 = (TextView) view.findViewById(R.id.currentprice1);
        text2 = (TextView) view.findViewById(R.id.riseprice1);
        text3 = (TextView) view.findViewById(R.id.risewidth1);
        text4 = (TextView) view.findViewById(R.id.riserating1);

        jongmok_code.setText(code);
        text1.setText(str_now);
        text2.setText(str_pok);
        text3.setText(str_semo);
        text4.setText(str_per);


        chart_webView = (WebView) view.findViewById(R.id.chart_webview);

        try {
            if (jsonObject.getString("semo").equalsIgnoreCase("▼")) {
                text1.setTextColor(Color.parseColor("#4B6BE3"));
                text2.setTextColor(Color.parseColor("#4B6BE3"));
                text3.setTextColor(Color.parseColor("#4B6BE3"));
                text4.setTextColor(Color.parseColor("#4B6BE3"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            if (jsonObject.getString("semo").equalsIgnoreCase("▲")) {
                text1.setTextColor(Color.parseColor("#C23041"));
                text2.setTextColor(Color.parseColor("#C23041"));
                text3.setTextColor(Color.parseColor("#C23041"));
                text4.setTextColor(Color.parseColor("#C23041"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        jongmok_code.setVisibility(GONE);
        text1.setVisibility(GONE);
        text2.setVisibility(GONE);
        text3.setVisibility(GONE);
        text4.setVisibility(GONE);

//        chart_webView.setWebViewClient(webViewClient);

        if(clearHistory) {
//            chart_webView.destroy();
//            chart_webView.setWebViewClient(webViewClient);
//            chart_webView.reload();
        }

//        if(clearHistory==true) {
//            chart_webView.clearHistory();
//            chart_webView.clearCache(true);
//            CookieManager cookieManager = CookieManager.getInstance();
//            cookieManager.removeSessionCookie();
//            chart_webView.loadUrl("http://61.72.187.6/attn/charts/dayindex?companycode=" + code);
//            clearHistory = false;
//        }
//
//        else {
//            chart_webView.clearHistory();
//            chart_webView.clearCache(true);
//            CookieManager cookieManager = CookieManager.getInstance();
//            cookieManager.removeSessionCookie();
//            chart_webView.loadUrl("http://61.72.187.6/attn/charts/weekindex?companycode=" + code);
//            clearHistory = true;
//        }
//
        chart_webView.loadUrl("http://61.72.187.6/attn/charts/dayindex?companycode=" + code);

        return view;
    }

//    class webClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//            url = "http://61.72.187.6/attn/charts/dayindex?companycode=";
//
//            view.loadUrl( url + code);
//
//            return false;
//        }
//    }

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            jongmok_code.setVisibility(VISIBLE);
            text1.setVisibility(VISIBLE);
            text2.setVisibility(VISIBLE);
            text3.setVisibility(VISIBLE);
            text4.setVisibility(VISIBLE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            jongmok_code.setVisibility(GONE);
            text1.setVisibility(GONE);
            text2.setVisibility(GONE);
            text3.setVisibility(GONE);
            text4.setVisibility(GONE);
        }
    }


    @SuppressLint("NewApi")
    @Override
    public void onResume() {
        super.onResume();
//        chart_webView.onResume();
    }

    @Override
    public void onPause() {
//        chart_webView.onPause();
        super.onPause();
    }

}