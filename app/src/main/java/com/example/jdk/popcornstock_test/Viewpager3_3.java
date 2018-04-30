package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.app.ListFragment;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v4.content.ContextCompat;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.androidquery.AQuery;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class Viewpager3_3 extends ListFragment {
//
//    public static Viewpager3_3 newInstance() {
//        return new Viewpager3_3();
//    }
//
//    Rank3_1Adapter adapter;
//
//    String json_string;
//    JSONObject jsonObject, object;
//    JSONArray companyJsonArray;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        adapter = new Rank3_1Adapter();
//        setListAdapter(adapter);
//
//        new JsonRankPage().execute();
//
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop1), "바오오오오밥", "999 ", " 신생 ", " 신규랭킹 1위 ", "인공지능" , " 737.09% ","|", "|", "|");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop2), "허니팝콘", "123 ", "", " 신규랭킹 2위 ", " 인공지능 " , " 737.00% ", "|", "", "|");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop3), "치즈팝콘", "5 ", "", " 신규랭킹 3위 ", "" , " 715.09% ", "|", "", "");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop4), "팝콘스탁", "88 ", " 신생 ", "", "" , " 701.09% ", "|", "", "");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop1), "바오밥솔루션", "101 ", "", " 주간랭킹 2위 ", "" , " 687.09% ", "|", "", "");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop2), "바오바오바오밥", "1K ", " 신생 ", "", " 인공지능 " , " 650.09% ", "|", "", "|");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop3), "바바바밥", "106 ", "", " 신규랭킹 7위 ", "" , " 701.09% ", "|", "", "");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop4), "팝콘스탁", "88 ", " 신생 ", "", "" , " 701.09% ", "|", "", "");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop1), "바오밥솔루션", "101 ", "", " 주간랭킹 2위 ", "" , " 687.09% ", "|", "", "");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop2), "바오바오바오밥", "1K ", " 신생 ", "", " 인공지능 " , " 650.09% ", "|", "", "|");
////        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop3), "바바바밥", "106 ", "", " 신규랭킹 7위 ", "" , " 701.09% ", "|", "", "");
//
//
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//    class JsonRankPage extends AsyncTask<String, Void, String> {
//
//        String JSON_STRING;
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            String Json_url = "https://charttest-sungheeek.c9users.io/example.json";
//
//            try {
//                URL url = new URL(Json_url);
//                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ));
//                StringBuilder stringBuilder = new StringBuilder();
//
//                while ( (JSON_STRING = bufferedReader.readLine()) != null )
//                {
//                    stringBuilder.append( JSON_STRING + "\n" );
//                }
//
//                bufferedReader.close();
//                inputStream.close();
//                httpURLConnection.disconnect();
//
//                return stringBuilder.toString().trim();
//            }
//
//            catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//
//            super.onProgressUpdate(values);
//
//        }
//
//        @Override
//        protected void onPreExecute() {
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//
//            if( json_string == null )
//            {
//                json_string = result;
//
//                try
//                {
//                    jsonObject = new JSONObject(json_string);
//                    companyJsonArray = jsonObject.getJSONArray( "companycode" );
//
//                    String comeName, suik, check;
//
//                    for (int i = 0; i < companyJsonArray.length(); i++)
//                    {
//                        object = companyJsonArray.getJSONObject(i);
//                        comeName = object.getString("company");
//                        suik = object.getString("suik");
//                        check = object.getString("check");
//
//                        adapter.addItem(comeName, suik, check);
//                        adapter.notifyDataSetChanged();
//                    }
//
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//}
