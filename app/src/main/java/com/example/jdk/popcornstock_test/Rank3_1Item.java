package com.example.jdk.popcornstock_test;

import android.graphics.drawable.Drawable;

import java.net.URI;

/**
 * Created by Heeju on 2017-12-11.
 */

public class Rank3_1Item {

    private String profile_icon;
    private String profile_nick;
    private String profile_content;
    private String profile_content2;
    private String profile_content3;
    private String profile_content4;
    private String profile_rank;

    public void setIcon( String icon )
    {
        profile_icon = icon;
    }

    public void setNick( String nick )
    {
        profile_nick = nick;
    }

    public void setCotent( String content )
    {
        profile_content = content;
    }

    public void setCotent2( String content2 )
    {
        profile_content2 = content2;
    }

    public void setCotent3( String content3 )
    {
        profile_content3 = content3;
    }

    public void setCotent4( String content4 )
    {
        profile_content4 = content4;
    }

    public void setRank( String rank )
    {
        profile_rank = rank;
    }

    public String getProfile()
    {
        return this.profile_icon;
    }

    public String getNick()
    {
        return this.profile_nick;
    }

    public String getContent()
    {
        return this.profile_content;
    }

    public String getContent2()
    {
        return this.profile_content2;
    }

    public String getContent3()
    {
        return this.profile_content3;
    }

    public String getContent4()
    {
        return this.profile_content4;
    }

    public String getRank()
    {
        return this.profile_rank;
    }
}
