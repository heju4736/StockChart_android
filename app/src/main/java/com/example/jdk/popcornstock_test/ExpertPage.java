package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.jdk.popcornstock_test.Viewpager3_1.str_phone;

public class ExpertPage extends Activity {

    ListView listview;
    String json_string;
    JSONObject jsonObject, headDAtaJsonObject, headDAtaJsonArray;
    JSONArray zongmokJsonArray;
    AQuery aQuery;

    Handler handler;
    Expert_ListAdapter adapter;

    TextView main_title, expert_title, expert_name, expert_income, expert_read;
    CircleImageView expert_img;

    String comeName, code, nowPrice, up_Down, Fluctuation, Buyer, targetPrice, Softy;

    public ArrayList<Expert_Item> items;

    private String TAG = ExpertPage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_page);

        listview = (ListView) findViewById(R.id.expert_jongmokList);

        main_title = (TextView) findViewById(R.id.mainTitle);
        expert_title = (TextView) findViewById(R.id.expert_title);
        expert_name = (TextView) findViewById(R.id.expert_name);
        expert_income = (TextView) findViewById(R.id.expert_income);
        expert_read = (TextView) findViewById(R.id.expert_read);
        expert_img = (CircleImageView) findViewById(R.id.expert_profile);

        adapter = new Expert_ListAdapter();
        listview.setAdapter(adapter);

        new JsonExpertPage().execute();



//        adapter.addItem("삼성전자", "21,000", "▲", "15,000", "17,000", "20,000", "1,500");
//        adapter.addItem("카카오", "24,000", "▲", "13,000", "16,000", "25,000", "1,900");
//        adapter.addItem("몰라몰라몰라", "19,000", "▼", "6,000", "19,000", "17,000", "5,300");
//        adapter.addItem("스튜디오드래곤", "11,000", "▲", "15,000", "11,000", "9,000", "1,000");
//        adapter.addItem("삼성전자", "21,000", "▲", "30,000", "22,000", "35,000", "3,000");
//        adapter.addItem("삼성전자", "21,000", "▼", "30,000", "20,000", "28,000", "5,500");

//        this.handler = new Handler();
//        this.handler.postDelayed( runnable, 3000);
    }

    class JsonExpertPage extends AsyncTask <String, Void, String> {

        String JSON_STRING;

        @Override
        protected String doInBackground(String... params) {

            String Json_url = "http://61.72.187.6/attn/mob/proPage?name=" + comeName + "&HP=" + str_phone;

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
                    headDAtaJsonObject = jsonObject.getJSONObject("head_data");
                    headDAtaJsonArray = headDAtaJsonObject.getJSONObject("head");
                    zongmokJsonArray = jsonObject.getJSONArray( "zongmok_data" );

                    for (int i = 0; i < zongmokJsonArray.length(); i++)
                    {
                        JSONObject object = zongmokJsonArray.getJSONObject(i);
                            comeName = object.getString("name");
                            code = object.getString("code");
                            nowPrice = object.getString("now");
                            up_Down = object.getString("try");
                            Fluctuation = object.getString("per");
                            Buyer = object.getString("buy");
                            targetPrice = object.getString("sell");
                            Softy = object.getString("cut");

                        adapter.addItem(comeName, code, nowPrice, up_Down, Fluctuation, Buyer, targetPrice, Softy);
                        adapter.notifyDataSetChanged();
                    }

                        String img_url ;

                        main_title.setText(headDAtaJsonArray.getString("name"));
                        expert_title.setText(headDAtaJsonArray.getString("title"));
                        img_url = headDAtaJsonArray.getString("imgurl");
                        expert_name.setText(headDAtaJsonArray.getString("name"));
                        expert_income.setText(headDAtaJsonArray.getString("suik"));
                        expert_read.setText(headDAtaJsonArray.getString("gudok"));

                        aQuery = new AQuery( ExpertPage.this );
                        aQuery.id( expert_img ).image( img_url );

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }


//    private final Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            Toast.makeText( ExpertPage.this, "refresh", Toast.LENGTH_SHORT).show();
//            ExpertPage.this.handler.postDelayed( runnable, 3000);
//        }
//    };

}

