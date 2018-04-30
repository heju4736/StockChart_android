package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidquery.AQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.jdk.popcornstock_test.Intro.phoneNum;
import static com.example.jdk.popcornstock_test.KakaoSignupActivity.kakaoProfile;


public class Fragment5 extends Fragment implements View.OnClickListener {

    ImageButton nickEdit_btn, test_btn, marketpower;
    CircleImageView nick_img;
    Button img_btn, product_btn, read_btn;
    static TextView hp_text, nick_text;

    AQuery aQuery;

    static String str_hp;
    static JSONObject jsonObject, object;

    static String str_nick;

    public static Fragment5 newInstance() {
        return new Fragment5();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment5, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        nickEdit_btn = (ImageButton) view.findViewById(R.id.nickEdit_Btn);
        nick_img = (CircleImageView) view.findViewById(R.id.profile_img);
        img_btn = (Button) view.findViewById(R.id.img_edit_Btn);
        hp_text = (TextView) view.findViewById(R.id.hp_text);
        nick_text = (TextView) view.findViewById(R.id.nick_text);
        product_btn = (Button) view.findViewById(R.id.usingProduct_Btn);
        product_btn.setOnClickListener(this);
        read_btn = (Button) view.findViewById(R.id.readingList_Btn);
        read_btn.setOnClickListener(this);

        new JsonNickGet().execute();

        ///TODO TEST_btn (바꾸기)
        marketpower = (ImageButton)view.findViewById(R.id.testWeb_btn);
        marketpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), marketpowerTest.class );
                startActivity(intent);
            }
        });

        test_btn = (ImageButton) view.findViewById(R.id.testBtn);
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), ExpertPage.class );
                startActivity(intent);
            }
        });

        hp_text = (TextView) view.findViewById(R.id.hp_text);

        hp_text.setText(phoneNum);

        str_hp = hp_text.getText().toString();


        aQuery = new AQuery( getActivity() );
        aQuery.id( nick_img ).image( kakaoProfile );

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), Img_Expand.class );
                startActivity(intent);
            }
        });

        nickEdit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NickEdit.class);
                startActivity(intent);
            }
        });

        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) {
            childFt.replace(R.id.frag5, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {

        Fragment fragment;

        switch (v.getId()) {
            default:

            case R.id.usingProduct_Btn: {
                fragment = new Viewpager5_2();
                setChildFragment(fragment);
                break;
            }

            case R.id.readingList_Btn: {
                fragment = new Viewpager5_3();
                setChildFragment(fragment);
                break;
            }
        }
    }

    static class JsonNickGet extends AsyncTask<String, Void, String> {

        String json_string;
        String JSON_STRING;

        @Override
        protected String doInBackground(String... params) {

            String Json_url = "http://61.72.187.6/phps/nickGet?user_hp=" + str_hp;

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

            if( json_string == null )
            {
                json_string = result;

                try
                {
                    jsonObject = new JSONObject(json_string);

                    str_nick = jsonObject.getString("nick");

                    nick_text.setText(str_nick);

                    }
                    catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}