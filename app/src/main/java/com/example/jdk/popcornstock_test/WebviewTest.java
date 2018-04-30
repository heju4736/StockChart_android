package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.app.Activity;
//import android.content.res.Configuration;
//import android.graphics.Bitmap;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.webkit.WebSettings;
//import android.webkit.WebViewClient;
//import android.widget.LinearLayout;
//
//import im.delight.android.webview.AdvancedWebView;
//
//import static com.baobob.popcornstock.Bottombar.code;
//import static com.baobob.popcornstock.Bottombar.jongmok;
//
//public class WebviewTest extends Activity implements AdvancedWebView.Listener{
////
////    static AdvancedWebView webtest;
////    LinearLayout linear1, linear2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_webview_test);
////
////        webtest = (AdvancedWebView) findViewById(R.id.web_test);
////
////        webtest.setListener(this, this);
////
////        WebSettings webSettings = webtest.getSettings();
////        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
////
////        webtest.setWebViewClient(new WebViewClient());
//
////        if (savedInstanceState == null)
////        {
////
////            webtest.loadUrl("http://61.72.187.6/attn/stockchart/index?companycode=") + jongmok;
////
////
////        }
//
//
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//
//        webtest.saveState(savedInstanceState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        webtest.restoreState(savedInstanceState);
//    }
//
//    @Override
//    public void onPageStarted(String url, Bitmap favicon) {
//
//    }
//
//    @Override
//    public void onPageFinished(String url) {
//
//    }
//
//    @Override
//    public void onPageError(int errorCode, String description, String failingUrl) {
//
//    }
//
//    @Override
//    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
//
//    }
//
//    @Override
//    public void onExternalPageRequest(String url) {
//
//    }
//}
