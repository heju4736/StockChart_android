package com.example.jdk.popcornstock_test;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Heeju on 2018-02-27.
 */

public class BackgroundJongmokSearch extends AsyncTask<String, Void, String> {

    Context context;

    BackgroundJongmokSearch(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];

        String gold = params[1];
        String power = params[2];
        String supply = params[3];
        String performance = params[4];
        String value = params[5];

        String rank_url = "http://61.72.187.6/attn/stockevent/index?gold=" + gold + "&power=" + power + "&supply=" + supply + "&performance=" + performance + "&value=" + value;

        if( type.equals("jongmok") ) {
            try {

                URL url = new URL(rank_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("gold", "UTF-8") + "=" + URLEncoder.encode( gold, "UTF-8") + "&"
                    + URLEncoder.encode("power", "UTF-8") + "=" + URLEncoder.encode( power, "UTF-8") + "&"
                    + URLEncoder.encode("supply", "UTF-8") + "=" + URLEncoder.encode( supply, "UTF-8") + "&"
                    + URLEncoder.encode("performance", "UTF-8") + "=" + URLEncoder.encode( performance, "UTF-8") + "&"
                    + URLEncoder.encode("value", "UTF-8") + "=" + URLEncoder.encode( value, "UTF-8") + "&";

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "EUC-KR"));

                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
