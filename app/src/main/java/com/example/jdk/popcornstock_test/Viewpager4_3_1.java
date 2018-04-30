package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

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
import java.util.List;

public class Viewpager4_3_1 extends Fragment {

    public static Viewpager4_3_1 newInstance() {
        return new Viewpager4_3_1();
    }

    Viewpager4_ListAdapter adapter;

    JSONObject jsonObject, object;

    ListView listview;

    static String str_code;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity4_3, container, false);

        listview = (ListView) view.findViewById(R.id.jump_listview);

        adapter = new Viewpager4_ListAdapter();
        listview.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        new JsonJumpPage().execute();

        return view;
    }

    class JsonJumpPage extends AsyncTask<String, Void, String> {

        String json_string;
        String JSON_STRING;

        @Override
        protected String doInBackground(String... params) {

            String Json_url = "http://61.72.187.6/phps/grow";

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

            String str_company, str_fist, str_percent, str_topic1, str_topic2, str_topic3;
            int int_fist;

            if( json_string == null )
            {
                json_string = result;

                adapter.Clear();
                try
                {
                    jsonObject = new JSONObject(json_string);
                    JSONArray jsonArray = jsonObject.getJSONArray("com");

                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            object = jsonArray.getJSONObject(i);
                            str_code = object.getString("code"); //이름
                            str_company = object.getString("company"); //수익률
                            int_fist = object.getInt("fist"); //구독수
                            str_percent = object.getString("percent"); //전문가/인공지능
                            str_topic1 = object.getString("topic1"); //몇등?, 신생
                            str_topic2 = object.getString("topic2"); //아무말
                            str_topic3 = object.getString("topic3");

                            str_fist = String.valueOf(int_fist);

                            adapter.addItem(  str_fist, str_company, str_percent, str_topic1, str_topic2, str_topic3 );
                            adapter.notifyDataSetChanged();
                        }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

}
