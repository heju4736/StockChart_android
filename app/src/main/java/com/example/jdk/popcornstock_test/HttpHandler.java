package com.example.jdk.popcornstock_test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Heeju on 2018-02-19.
 */

public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    public String makeServiceCall( String reqUrl ) {

        String responce = null;

        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream( conn.getInputStream() );
            responce = convertStreamToString( inputStream );
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return responce;
    }

    private String convertStreamToString( InputStream inputStream ) {

        BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        try {
            while( (line = reader.readLine()) != null )
            {
                stringBuilder.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }


}
