package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.widget.Toast;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import static com.baobob.popcornstock.Fragment5.str_hp;
//
//
//public class BackgroundNickGet extends AsyncTask <String, Void, String> {
//
//    Context context;
//    static String nick_result;
//
//    BackgroundNickGet(Context context )
//    {
//        this.context = context;
//    }
//
//
//
//    @Override
//    protected String doInBackground(String... params) {
//
//        String reg_url = "http://61.72.187.6/phps/nickGet?user_hp=" + str_hp;
//
//        String method = params[0];
//
//        if( method.equals("nickGet") )
//        {
//            String user_hp = params[1];
//
//            try {
//                URL url = new URL(reg_url);
//                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//                httpURLConnection.setRequestMethod( "GET" );
//                httpURLConnection.setDoOutput( true );
//
//                OutputStream OS = httpURLConnection.getOutputStream();
//
//                BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(OS, "UTF-8") );
//
//                String data = URLEncoder.encode("user_hp", "UTF-8" ) + "=" + URLEncoder.encode( user_hp, "UTF-8");
//
//                bufferedWriter.write( data );
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                OS.close();
//
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "EUC-KR"));
//
//                StringBuilder myResult = new StringBuilder();
//                String line = "";
//
//                while ((line = bufferedReader.readLine()) != null) {
//                    myResult.append( line );
//                }
//
//                nick_result = myResult.toString();
//
//                bufferedReader.close();
//                inputStream.close();
//                httpURLConnection.disconnect();
//
//                return nick_result;
//            }
//
//            catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    protected void onProgressUpdate(Void... values) {
//
//        super.onProgressUpdate(values);
//
//    }
//
//    @Override
//    protected void onPreExecute() {
//    }
//
//    @Override
//    protected void onPostExecute(String nick_result) {
//
//        if( nick_result.length() >= 13 )
//        {
//            Toast.makeText(context, nick_result, Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
//}
