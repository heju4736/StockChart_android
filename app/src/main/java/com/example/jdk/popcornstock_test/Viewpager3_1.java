package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.jdk.popcornstock_test.Intro.phoneNum;
import static com.example.jdk.popcornstock_test.Viewpager3_2.rankNick;
import static com.example.jdk.popcornstock_test.Viewpager3_2.str_expert;
import static com.example.jdk.popcornstock_test.Viewpager3_2.str_gudok;
import static com.example.jdk.popcornstock_test.Viewpager3_2.str_suik;

public class Viewpager3_1 extends Fragment {

    ImageButton all_btn, read_btn;

    ImageView all_on, read_on;

    TextView phone;

    Rank3_1Adapter adapter;

    JSONObject jsonObject, object, object2;
    JSONArray allJsonArray, readJsonArray;

    ListView listview;

    static String str_phone = "";
    String image, name, yie, sub, race, tag1, tag2;
    static int all = 0;

    public static Viewpager3_1 newInstance() {
        return new Viewpager3_1();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_viewpager3_1, container, false);

        all_btn = (ImageButton) view.findViewById(R.id.allBtn);
        read_btn = (ImageButton) view.findViewById(R.id.readBtn);

        phone = (TextView) view.findViewById(R.id.phone_rank);
        phone.setText(phoneNum);
        str_phone = phone.getText().toString();

        all_on = (ImageView) view.findViewById(R.id.all_img);
        read_on = (ImageView) view.findViewById(R.id.read_img);

        listview = (ListView) view.findViewById(R.id.frag3_list);

        adapter = new Rank3_1Adapter();
        listview.setAdapter(adapter);

        new JsonRankPage().execute();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String type = "get_exepert";

                BackgroundExpert backgroundExpert = new BackgroundExpert(getActivity());
                backgroundExpert.execute( type, name, str_phone);
            }
        });

        all = 0;

        all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all_btn.setVisibility(GONE);
                all_on.setVisibility(VISIBLE);
                read_btn.setVisibility(VISIBLE);
                read_on.setVisibility(GONE);

                all = 0;

                new JsonRankPage().execute();

            }
        });

        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                all = 1;

//            try {
//                adapter.Clear();
//
//                String comeName, suik, check;
//
//                for (int i = 0; i < companyJsonArray.length(); i++)
//                {
//                    object = companyJsonArray.getJSONObject(i);
//                    check = object.getString("check");
//                    if (check == "true") {
//                        comeName = object.getString("company");
//                        suik = object.getString("suik");
//                        adapter.addItem(comeName, suik, check);
//                        adapter.notifyDataSetChanged();
//                    }
//                }
//            }
//            catch (JSONException e)
//            {
//                e.printStackTrace();
//            }

                all_btn.setVisibility(VISIBLE);
                all_on.setVisibility(GONE);
                read_btn.setVisibility(GONE);
                read_on.setVisibility(VISIBLE);

                new JsonRankPage().execute();

            }
        });


        return view;
    }

    class JsonRankPage extends AsyncTask<String, Void, String> {

        String json_string;
        String JSON_STRING;

        @Override
        protected String doInBackground(String... params) {

            String Json_url = "http://61.72.187.6/phps/rank?HL=" + str_suik + "&MF=" + str_gudok + "&HR=" + str_expert + "&text=" + rankNick + "&HP=" + str_phone;

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

                adapter.Clear();
                try
                {
                    jsonObject = new JSONObject(json_string);
                    allJsonArray = jsonObject.getJSONArray( "all" );
                    readJsonArray = jsonObject.getJSONArray("sub");

                    if (all == 0)
                    {
                        for (int i = 0; i < allJsonArray.length(); i++)
                        {
                            object = allJsonArray.getJSONObject(i);
                            name = object.getString("name"); //이름
                            yie = object.getString("yie"); //수익률
                            sub = object.getString("sub"); //구독수
                            race = object.getString("race"); //전문가/인공지능
                            tag1 = object.getString("tag1"); //몇등?, 신생
                            tag2 = object.getString("tag2"); //아무말
                            image = object.getString("image");

                            adapter.addItem(name, sub, tag1, race, tag2, yie);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    else if( all == 1 )
                    {
                        for (int i = 0; i < readJsonArray.length(); i++)
                        {
                            object = readJsonArray.getJSONObject(i);
                            name = object.getString("name");
                            yie = object.getString("yie");
                            sub = object.getString("sub");
                            race = object.getString("race");
                            tag1 = object.getString("tag1");
                            tag2 = object.getString("tag2");
                            image = object.getString("image");

                            adapter.addItem(name, sub, tag1, race, tag2, yie);
                            adapter.notifyDataSetChanged();
                        }
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
