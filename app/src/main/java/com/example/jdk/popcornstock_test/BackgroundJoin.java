package com.example.jdk.popcornstock_test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
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

/**
 * Created by Heeju on 2018-02-02.
 */

public class BackgroundJoin extends AsyncTask <String, Void, String> {

    Context context;

    BackgroundJoin(Context context )
    {
        this.context = context;
    }



    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://61.72.187.6/phps/join.php";

        String method = params[0];

        if( method.equals("register") )
        {
            String user_id = params[1];
            String user_pw = params[2];
            String user_email = params[3];
            String user_nick = params[4];
            String user_hp = params[5];
            String user_di = params[6];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod( "POST" );
                httpURLConnection.setDoOutput( true );

                OutputStream OS = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(OS, "UTF-8") );

                String data = URLEncoder.encode("user_id", "UTF-8" ) + "=" + URLEncoder.encode( user_id, "UTF-8") + "&"
                        + URLEncoder.encode("user_pw", "UTF-8" ) + "=" + URLEncoder.encode( user_pw, "UTF-8") + "&"
                        + URLEncoder.encode("user_email", "UTF-8" ) + "=" + URLEncoder.encode( user_email, "UTF-8") + "&"
                        + URLEncoder.encode("user_nick", "UTF-8" ) + "=" + URLEncoder.encode( user_nick, "UTF-8") + "&"
                        + URLEncoder.encode("user_hp", "UTF-8" ) + "=" + URLEncoder.encode( user_hp, "UTF-8") + "&"
                        + URLEncoder.encode("user_di", "UTF-8" ) + "=" + URLEncoder.encode( user_di, "UTF-8");

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

        if( result.length() == 3)
        {
            Toast.makeText(context, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent( context, Login.class);
            context.startActivity(intent);
        }

        else
        {
            int length = result.length();

            switch( length )
            {
                case 4:
                    Toast.makeText( context, "중복된 사용자 입니다 (한 번호당 한명씩 가입 가능)", Toast.LENGTH_SHORT).show();
                    break;

                case 5:
                    Toast.makeText( context, "아이디에 특수문자나 공백은 사용할 수 없습니다", Toast.LENGTH_SHORT).show();
                    break;

                case 6:
                    Toast.makeText( context, "아이디 길이는 6자 이상 12자 이하만 가능합니다", Toast.LENGTH_SHORT).show();
                    break;

                case 7:
                    Toast.makeText( context, "비밀번호에 특수문자나 공백은 사용할 수 없습니다", Toast.LENGTH_SHORT).show();
                    break;

                case 8:
                    Toast.makeText( context, "비밀번호 길이는 6자 이상 12자 이하만 가능합니다", Toast.LENGTH_SHORT).show();
                    break;

                case 9:
                    Toast.makeText( context, "정상적인 이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                    break;

                case 10:
                    Toast.makeText( context, "닉네임에 일부 특수문자는 사용할 수 없습니다", Toast.LENGTH_SHORT).show();
                    break;

                case 11:
                    Toast.makeText( context, "중복된 아이디입니다", Toast.LENGTH_SHORT).show();
                    break;

                case 12:
                    Toast.makeText( context, "이미 카카오톡 로그인을 사용중인 계정입니다", Toast.LENGTH_SHORT).show();
                    break;

                default:

                    break;
            }
        }

        //        if (result) {
//
//            Intent intent = new Intent(context, Login.class);
//            context.startActivity(intent);
//
//        }
//        else  {
//            word = "회원가입 실패";
//            alertDialog.setMessage(word);
//        }
//        else {
//            alertDialog.setMessage(word);
//        }
    }
}
