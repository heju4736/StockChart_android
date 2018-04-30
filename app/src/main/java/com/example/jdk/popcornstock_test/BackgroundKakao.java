package com.example.jdk.popcornstock_test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;
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
import java.text.SimpleDateFormat;
import java.util.Date;


public class BackgroundKakao extends AsyncTask <String, Void, String> {

    Context context;

    BackgroundKakao( Context context )
    {
        this.context = context;
    }



    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://61.72.187.6/phps/kakaoLogin.php";

        String method = params[0];

        if( method.equals("kakaoLogin") )
        {
            String id = params[1];
            String nick = params[2];
            String email = params[3];
            String user_code = params[4];
            String hp = params[5];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod( "POST" );
                httpURLConnection.setDoOutput( true );

                OutputStream OS = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(OS, "UTF-8") );

                String data = URLEncoder.encode("id", "UTF-8" ) + "=" + URLEncoder.encode( id, "UTF-8") + "&"
                        + URLEncoder.encode("nick", "UTF-8" ) + "=" + URLEncoder.encode( nick, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8" ) + "=" + URLEncoder.encode( email, "UTF-8") + "&"
                        + URLEncoder.encode("user_code", "UTF-8" ) + "=" + URLEncoder.encode( user_code, "UTF-8") + "&"
                        + URLEncoder.encode("hp", "UTF-8" ) + "=" + URLEncoder.encode( hp, "UTF-8");

                bufferedWriter.write( data );
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
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
    }

    @Override
    protected void onPostExecute(String result) {

        if( result.length() == 5)
        {
            Toast.makeText(context, "이미 일반회원으로 가입된 계정입니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Login.class);
            context.startActivity(intent);
        }


    }
}
