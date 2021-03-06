package com.example.jdk.popcornstock_test;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class BackgroundRank extends AsyncTask<String, Void, String> {

    Context context;

    BackgroundRank( Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];

        String HL = params[1];
        String MF = params[2];
        String HR = params[3];
        String text = params[4];
        String HP = params[5];

        String rank_url = "http://61.72.187.6/phps/rank?HL=" + HL + "&MF=" + MF + "&HR=" + HR + "&text=" + text + "&HP=" + HP;


        if( type.equals("rank_data") ) {
            try {

                URL url = new URL(rank_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("HP", "UTF-8") + "=" + URLEncoder.encode( HP, "UTF-8") + "&"
                        + URLEncoder.encode("HL", "UTF-8") + "=" + URLEncoder.encode( HL, "UTF-8") + "&"
                        + URLEncoder.encode("MF", "UTF-8") + "=" + URLEncoder.encode( MF, "UTF-8") + "&"
                        + URLEncoder.encode("HR", "UTF-8") + "=" + URLEncoder.encode( HR, "UTF-8") + "&"
                        + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode( text, "UTF-8") + "&";

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

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {

    }
}
