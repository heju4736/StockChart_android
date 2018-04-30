package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.kakao.util.helper.log.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.jdk.popcornstock_test.Intro.phoneNum;
import static com.example.jdk.popcornstock_test.Viewpager1_4.news_webview;
import static com.kakao.util.helper.Utility.getPackageInfo;

public class Bottombar extends Activity {

    ImageView img1, img2, img3, img4, img5;
    Button menuBtn1, menuBtn2, menuBtn3, menuBtn4, menuBtn5, mainlist_btn;

    ImageButton chart_btn, hoga_btn, jongmok_btn, news_btn;
    ImageView img1_1, img1_2, img1_3;

    ImageButton alarm_Btn, search_Btn, img1_4;

    LinearLayout frame1, frame3, back_img, search_layout;
    FrameLayout frame2;
    static TextView maintitle, hp_text;
    ListView listview;
    EditText search_edit;
    ImageButton cancel_btn;

    ImageButton jongmokSearch_btn;

    static String json_string;
    static JSONObject jsonObject;

    String main_jongmok;

    TextView jongmok_name, jongmok_code, now, pok, semo, per;

    int int_now, int_pok, siga;

    static String str_jongmokName, str_semo, str_now, str_pok, str_siga,  str_per;
    static String code;

    static String jongmok;
    static String chart_url;

    boolean web = false;

    LinearLayout linear1, linear2, linear3, linear4;

    TextView jongmok_text;

    RadioButton min_radio, day_radio, week_radio, mon_radio;

    private BackPressCloseHandler backPressCloseHandler;

    private static final String TAG = "kakao";

    public static boolean clearHistory = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottombar);

        backPressCloseHandler = new BackPressCloseHandler(this);

        hp_text = (TextView) findViewById(R.id.main_phone);
        hp_text.setText(phoneNum);

        now = (TextView) findViewById(R.id.currentprice);
        pok = (TextView) findViewById(R.id.riseprice);
        semo = (TextView) findViewById(R.id.risewidth);
        per = (TextView) findViewById(R.id.riserating);

        linear1 = (LinearLayout) findViewById(R.id.linear_land1);
        linear2 = (LinearLayout) findViewById(R.id.linear_land2);
        linear3 = (LinearLayout) findViewById(R.id.linear_land3);
        linear4 = (LinearLayout) findViewById(R.id.linear_land4);

        jongmok_text = (TextView)findViewById(R.id.jongmok_text);

        img1 = (ImageView) findViewById(R.id.menuimg1);
        img2 = (ImageView) findViewById(R.id.menuimg2);
        img3 = (ImageView) findViewById(R.id.menuimg3);
        img4 = (ImageView) findViewById(R.id.menuimg4);
        img5 = (ImageView) findViewById(R.id.menuimg5);
        menuBtn1 = (Button) findViewById(R.id.menuBtn1);
        menuBtn2 = (Button) findViewById(R.id.menuBtn2);
        menuBtn3 = (Button) findViewById(R.id.menuBtn3);
        menuBtn4 = (Button) findViewById(R.id.menuBtn4);
        menuBtn5 = (Button) findViewById(R.id.menuBtn5);

        chart_btn = (ImageButton) findViewById(R.id.chart_btn);
        jongmok_btn = (ImageButton) findViewById(R.id.jongmok_btn);
        news_btn = (ImageButton) findViewById(R.id.news_btn);
        img1_1 = (ImageView) findViewById(R.id.frag1_1img);
        img1_3 = (ImageView) findViewById(R.id.frag1_3img);
        img1_4 = (ImageButton) findViewById(R.id.frag1_4img);

        min_radio = (RadioButton) findViewById(R.id.min_radio);
        day_radio = (RadioButton) findViewById(R.id.day_radio);
        week_radio = (RadioButton) findViewById(R.id.week_radio);
        mon_radio = (RadioButton) findViewById(R.id.mon_radio);


        maintitle = (TextView) findViewById(R.id.mainTitle);

        frame1 = (LinearLayout) findViewById(R.id.mainlayout);
        frame2 = (FrameLayout) findViewById(R.id.container);
        frame3 = (LinearLayout) findViewById(R.id.main_listview);
        back_img = (LinearLayout) findViewById(R.id.back_img);

        search_Btn = (ImageButton) findViewById(R.id.main_searchBtn);

        mainlist_btn = (Button) findViewById(R.id.frag1_imgbtn);

        search_layout = (LinearLayout) findViewById(R.id.search_layout);
        search_edit = (EditText) findViewById(R.id.search_edit);
        cancel_btn = (ImageButton) findViewById(R.id.cancel_btn);
        jongmokSearch_btn = (ImageButton) findViewById(R.id.jongmokSearch_btn);

        //   new JsonExpertPage().execute();

        FirebaseMessaging.getInstance().subscribeToTopic("noticeMsg");


        search_layout.setVisibility(GONE);

        ///TODO search
        search_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_layout.setVisibility(VISIBLE);
                back_img.setVisibility(VISIBLE);

                search_layout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        search_layout.setVisibility(GONE);
                        back_img.setVisibility(GONE);
                        search_edit.setText(null);
                        return true;
                    }
                });

                back_img.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        search_layout.setVisibility(GONE);
                        back_img.setVisibility(GONE);
                        search_edit.setText(null);
                        return true;
                    }
                });

                byte[] sha1 = {
                        0x3B, (byte)0xDA, (byte)0xA0, 0x5B, 0x4F, 0x35, 0x71, 0x02, 0x4E, 0x27, 0x22, (byte)0xB9, (byte)0xAc, (byte)0xB2, 0x77, 0x2F, (byte)0x9D, (byte)0xA9, (byte)0x9B, (byte)0xD9
                };
                Logger.e("keyHash: " + Base64.encodeToString(sha1, Base64.NO_WRAP));
//                Logger.e("debug key" + getKeyHash(getApplicationContext()));

            }
        });

        jongmokSearch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jongmok = search_edit.getText().toString();

                ///TODO 키보드 없애기
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(search_edit.getWindowToken(),0);

                search_layout.setVisibility(GONE);
                back_img.setVisibility(GONE);


                String type = "jongmokSearch_set";
                Backgroundjongmok backgroundjongmok = new Backgroundjongmok( Bottombar.this );
                backgroundjongmok.execute(type, jongmok);

                new JsonExpertPage().execute();
            }
        });


        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_edit.setText(null);
            }
        });




        ///TODO listview
        listview = (ListView) findViewById(R.id.main_list);
        MainList_Adapter adapter;

        adapter = new MainList_Adapter();
        listview.setAdapter(adapter);

        adapter.addItem("삼성전자");
        adapter.addItem("카카오");
        adapter.addItem("신한은행");
        adapter.addItem("국민은행");
        adapter.addItem("아아ㅏ아아");
        adapter.addItem("가가가나나");
        adapter.addItem("다라마바");




        menuBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frame1.setVisibility(VISIBLE);
                frame2.setVisibility(GONE);
                mainlist_btn.setVisibility(VISIBLE);

                menuBtn1.setVisibility(GONE);
                menuBtn2.setVisibility(VISIBLE);
                menuBtn3.setVisibility(VISIBLE);
                menuBtn4.setVisibility(VISIBLE);
                menuBtn5.setVisibility(VISIBLE);

                search_Btn.setVisibility(VISIBLE);

                img1.setVisibility(VISIBLE);
                img2.setVisibility(GONE);
                img3.setVisibility(GONE);
                img4.setVisibility(GONE);
                img5.setVisibility(GONE);
            }
        });

        ///TODO mainList setting
        mainlist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frame3.setVisibility(VISIBLE);
                frame2.setVisibility(GONE);
                back_img.setVisibility(VISIBLE);

                frame3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        frame3.setVisibility(GONE);
                        back_img.setVisibility(GONE);
                        return true;
                    }
                });

                back_img.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        frame3.setVisibility(GONE);
                        back_img.setVisibility(GONE);
                        return true;
                    }
                });
            }
        });

        img1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news_webview.loadUrl( "https://newscrolling-sungheeek.c9users.io/crolling.html?companycode=" + code );
            }
        });

    }

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            linear1.setVisibility(GONE);
            linear2.setVisibility(GONE);
            linear3.setVisibility(GONE);
            linear4.setVisibility(GONE);
        }

        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            linear1.setVisibility(VISIBLE);
            linear2.setVisibility(VISIBLE);
            linear3.setVisibility(VISIBLE);
            linear4.setVisibility(VISIBLE);
        }
    }


    class JsonExpertPage extends AsyncTask<String, Void, String> {

        String JSON_STRING;

        @Override
        protected String doInBackground(String... params) {


            String Json_url = "http://61.72.187.6/phps/now?name=" + jongmok;

            try {
                URL url = new URL(Json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ));
                StringBuilder stringBuilder = new StringBuilder();

                while ( (JSON_STRING = bufferedReader.readLine()) != null )
                {
                    stringBuilder.append( JSON_STRING + "\n" );
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();
            }

            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);

        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String result) {


                json_string = result;

                try
                {
                    jsonObject = new JSONObject(json_string);

                    str_jongmokName = jsonObject.getString("name");
                    code = jsonObject.getString("code");
                    int_now = jsonObject.getInt("now");
                    int_pok = jsonObject.getInt("pok");
                    str_semo = jsonObject.getString("semo");
                    str_per = jsonObject.getString("per");

                    siga = jsonObject.getInt("si");

                    str_now = String.valueOf( int_now );

                    long value = Long.parseLong(str_now);
                    DecimalFormat format = new DecimalFormat("###,###,###");//콤마
                    format.format(value);
                    String result_int = format.format(value);

                    str_pok = String.valueOf( int_pok );

                    long value2 = Long.parseLong(str_pok);
                    DecimalFormat format2 = new DecimalFormat("###,###");//콤마
                    format2.format(value2);
                    String result_int2 = format2.format(value2);

                    if( jsonObject.getString("name").equalsIgnoreCase("0") )
                    {
                        Toast.makeText(getApplicationContext() , "정확한 종목명이나 종목코드를 입력해주세요", Toast.LENGTH_SHORT).show();
                    }

                    jongmok_text.setText(str_jongmokName + " (" + code + ")");
//                    jongmok_code.setText(code);
                    now.setText(result_int);
                    pok.setText(result_int2);
                    semo.setText(str_semo);
                    per.setText(str_per + " %");

//                    maintitle.setText(str_jongmokName);

                    if( jsonObject.getString("semo").equalsIgnoreCase("▼") )
                    {
//                        jongmok_name.setTextColor(Color.parseColor("#4B6BE3"));
//                        jongmok_code.setTextColor(Color.parseColor("#4B6BE3"));
                        now.setTextColor(Color.parseColor("#4B6BE3"));
                        pok.setTextColor(Color.parseColor("#4B6BE3"));
                        semo.setTextColor(Color.parseColor("#4B6BE3"));
                        per.setTextColor(Color.parseColor("#4B6BE3"));
                    }

                    if( jsonObject.getString("semo").equalsIgnoreCase("▲") )
                    {
//                        jongmok_name.setTextColor(Color.parseColor("#C23041"));
//                        jongmok_code.setTextColor(Color.parseColor("#C23041"));
                        now.setTextColor(Color.parseColor("#C23041"));
                        pok.setTextColor(Color.parseColor("#C23041"));
                        semo.setTextColor(Color.parseColor("#C23041"));
                        per.setTextColor(Color.parseColor("#C23041"));
                    }

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    Viewpager1_1 fragment1 = new Viewpager1_1();
                    fragmentTransaction.add(R.id.frag1, fragment1);
                    fragmentTransaction.commit();

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
    }


    ///TODO bottomBar
    public void ChangeFragment( View v ) {

        Fragment fragment = null;

        switch( v.getId() ) {
            default:

            case R.id.menuBtn1: {

                frame1.setVisibility(VISIBLE);
                frame2.setVisibility(GONE);
                frame3.setVisibility(GONE);
                mainlist_btn.setVisibility(VISIBLE);
                back_img.setVisibility(GONE);

                jongmok_text.setText(str_jongmokName + " (" + code + ")");

                search_Btn.setVisibility(VISIBLE);

                menuBtn1.setVisibility(GONE);
                menuBtn2.setVisibility(VISIBLE);
                menuBtn3.setVisibility(VISIBLE);
                menuBtn4.setVisibility(VISIBLE);
                menuBtn5.setVisibility(VISIBLE);

                img1.setVisibility(VISIBLE);
                img2.setVisibility(GONE);
                img3.setVisibility(GONE);
                img4.setVisibility(GONE);
                img5.setVisibility(GONE);
                break;
            }


            case R.id.menuBtn2: {

                frame1.setVisibility(GONE);
                frame2.setVisibility(VISIBLE);
                frame3.setVisibility(GONE);
                mainlist_btn.setVisibility(GONE);
                back_img.setVisibility(GONE);

                jongmok_text.setText("종목검색");

                search_Btn.setVisibility(GONE);

                fragment = new Fragment2();
                menuBtn1.setVisibility(VISIBLE);
                menuBtn2.setVisibility(GONE);
                menuBtn3.setVisibility(VISIBLE);
                menuBtn4.setVisibility(VISIBLE);
                menuBtn5.setVisibility(VISIBLE);

                img1.setVisibility(GONE);
                img2.setVisibility(VISIBLE);
                img3.setVisibility(GONE);
                img4.setVisibility(GONE);
                img5.setVisibility(GONE);
                break;
            }

            case R.id.menuBtn3: {

                frame1.setVisibility(GONE);
                frame2.setVisibility(VISIBLE);
                frame3.setVisibility(GONE);
                mainlist_btn.setVisibility(GONE);
                back_img.setVisibility(GONE);

                jongmok_text.setText("팝콘랭킹");

                fragment = new Fragment3();
                menuBtn1.setVisibility(VISIBLE);
                menuBtn2.setVisibility(VISIBLE);
                menuBtn3.setVisibility(GONE);
                menuBtn4.setVisibility(VISIBLE);
                menuBtn5.setVisibility(VISIBLE);

                search_Btn.setVisibility(GONE);

                img3.setVisibility(VISIBLE);
                img1.setVisibility(GONE);
                img2.setVisibility(GONE);
                img4.setVisibility(GONE);
                img5.setVisibility(GONE);

                String phone = hp_text.getText().toString();
                String str_suik = "0";
                String str_gudok = "0";
                String str_expert = "0";
                String str_rankNick = "";

                String type = "rank_data";

                BackgroundRank backgroundWorker = new BackgroundRank(this);
                backgroundWorker.execute(type, str_suik, str_gudok, str_expert, str_rankNick, phone);

                break;
            }

            case R.id.menuBtn4: {

                frame1.setVisibility(GONE);
                frame2.setVisibility(VISIBLE);
                frame3.setVisibility(GONE);
                mainlist_btn.setVisibility(GONE);
                back_img.setVisibility(GONE);

                fragment = new Fragment4();
                menuBtn1.setVisibility(VISIBLE);
                menuBtn2.setVisibility(VISIBLE);
                menuBtn3.setVisibility(VISIBLE);
                menuBtn4.setVisibility(GONE);
                menuBtn5.setVisibility(VISIBLE);

                search_Btn.setVisibility(GONE);

                img4.setVisibility(VISIBLE);
                img1.setVisibility(GONE);
                img2.setVisibility(GONE);
                img3.setVisibility(GONE);
                img5.setVisibility(GONE);
                break;
            }

            case R.id.menuBtn5: {

                frame1.setVisibility(GONE);
                frame2.setVisibility(VISIBLE);
                frame3.setVisibility(GONE);
                mainlist_btn.setVisibility(GONE);
                back_img.setVisibility(GONE);

                jongmok_text.setText("더보기");

                fragment = new Fragment5();
                menuBtn1.setVisibility(VISIBLE);
                menuBtn2.setVisibility(VISIBLE);
                menuBtn3.setVisibility(VISIBLE);
                menuBtn4.setVisibility(VISIBLE);
                menuBtn5.setVisibility(GONE);

                search_Btn.setVisibility(GONE);

                img5.setVisibility(VISIBLE);
                img1.setVisibility(GONE);
                img2.setVisibility(GONE);
                img3.setVisibility(GONE);
                img4.setVisibility(GONE);

                break;
            }
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.container, fragment );
        fragmentTransaction.commit();
    }

    public void ChangeFragment2( View v ) {

        Fragment fragment;

        switch( v.getId() ) {
            default:


            case R.id.chart_btn: {

                frame1.setVisibility(VISIBLE);
                frame2.setVisibility(GONE);

                fragment = new Viewpager1_1();
                chart_btn.setVisibility(GONE);
                jongmok_btn.setVisibility(VISIBLE);
                news_btn.setVisibility(VISIBLE);

                img1_1.setVisibility(VISIBLE);
                img1_3.setVisibility(GONE);
                img1_4.setVisibility(GONE);
                break;
            }

            case R.id.jongmok_btn: {

                frame1.setVisibility(VISIBLE);
                frame2.setVisibility(GONE);

                fragment = new Viewpager1_3();
                chart_btn.setVisibility(VISIBLE);
                jongmok_btn.setVisibility(GONE);
                news_btn.setVisibility(VISIBLE);

                img1_1.setVisibility(GONE);
                img1_3.setVisibility(VISIBLE);
                img1_4.setVisibility(GONE);
                break;
            }

            case R.id.news_btn: {

                frame1.setVisibility(VISIBLE);
                frame2.setVisibility(GONE);

                fragment = new Viewpager1_4();
                chart_btn.setVisibility(VISIBLE);
                jongmok_btn.setVisibility(VISIBLE);
                news_btn.setVisibility(GONE);

                img1_1.setVisibility(GONE);
                img1_3.setVisibility(GONE);
                img1_4.setVisibility(VISIBLE);

//                news_webview.loadUrl( "https://newscrolling-sungheeek.c9users.io/crolling.html?companycode=" + code );
                break;
            }
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.frag1, fragment );
        fragmentTransaction.commit();
    }

//    public static String getKeyHash(final Context context) {
//        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
//        if (packageInfo == null)
//            return null;
//
//        for (Signature signature : packageInfo.signatures) {
//            try {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
//            } catch (NoSuchAlgorithmException e) {
//                Log.w(TAG, "Unable to get MessageDigest. signature=" + signature, e);
//            }
//        }
//        return null;
//    }


    //
//    public void onBackPressed()
//    {
//        backPressCloseHandler.onBackPressed();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
