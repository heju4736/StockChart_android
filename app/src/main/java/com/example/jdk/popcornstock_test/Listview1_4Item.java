package com.example.jdk.popcornstock_test;

import android.graphics.drawable.Drawable;

/**
 * Created by Heeju on 2017-12-11.
 */

public class Listview1_4Item {

    private String news_title;
    private String news_reporter;
    private String news_time;

    public void setTitle( String title )
    {
        news_title = title;
    }

    public void setReporter( String reporter )
    {
        news_reporter = reporter;
    }

    public void setTime( String time )
    {
        news_time = time;
    }


    public String getTitle()
    {
        return this.news_title;
    }

    public String getReporter()
    {
        return this.news_reporter;
    }

    public String getTime()
    {
        return this.news_time;
    }
}
