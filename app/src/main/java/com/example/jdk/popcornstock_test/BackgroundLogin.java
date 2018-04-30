package com.example.jdk.popcornstock_test;

import android.app.AlertDialog;
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


public class BackgroundLogin extends AsyncTask<String, Void, String> {

    Context context;
    static String nick_origin;

    BackgroundLogin(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];

        String login_url = "http://61.72.187.6/phps/login";

        String user_name = params[1];
        String password = params[2];
        String user_code = params[3];

        if (type.equals("login")) {
            try {

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                        + URLEncoder.encode("user_code", "UTF-8") + "=" + URLEncoder.encode(user_code, "UTF-8") ;

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "EUC-KR"));

                StringBuilder myResult = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    myResult.append( line );
                }

                nick_origin = myResult.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return nick_origin;
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
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute( String nick_origin ) {

        if( nick_origin.length() == 15 )
        {
            Toast.makeText( context, "로그인에 실패하셨습니다 \n아이디와 비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText( context, nick_origin + "님 환영합니다", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent( context, Bottombar.class);
            context.startActivity(intent);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

