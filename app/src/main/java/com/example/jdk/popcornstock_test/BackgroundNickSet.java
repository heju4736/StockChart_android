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


public class BackgroundNickSet extends AsyncTask <String, Void, String> {

    Context context;

    BackgroundNickSet(Context context )
    {
        this.context = context;
    }



    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://61.72.187.6/phps/nickSet.php";

        String method = params[0];

        if( method.equals("nickSet") )
        {
            String user_nick = params[1];
            String user_hp = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod( "POST" );
                httpURLConnection.setDoOutput( true );

                OutputStream OS = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(OS, "UTF-8") );

                String data = URLEncoder.encode("user_nick", "UTF-8" ) + "=" + URLEncoder.encode( user_nick, "UTF-8") + "&"
                        + URLEncoder.encode("user_hp", "UTF-8" ) + "=" + URLEncoder.encode( user_hp, "UTF-8") ;

                bufferedWriter.write( data );
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "EUC-KR"));

                StringBuilder myResult = new StringBuilder();
                String line = "";


                String nick = myResult.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return nick;
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
    }

    @Override
    protected void onPostExecute(String nick) {


    }
}
