package com.example.jdk.popcornstock_test;

import android.graphics.drawable.Drawable;

/**
 * Created by Heeju on 2017-12-11.
 */

public class Rank3_2Item {

    private Drawable profile_icon;
    private String profile_nick;
    private String profile_content;
    private String profile_content2;
    private String profile_content3;
    private String profile_content4;
    private String profile_cont;
    private String profile_cont2;
    private String profile_cont3;
    private String profile_rank;

    public void setIcon( Drawable icon )
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

    public void setCont( String cont )
    {
        profile_cont = cont;
    }

    public void setCont2( String cont2 )
    {
        profile_cont2 = cont2;
    }

    public void setCont3( String cont3 )
    {
        profile_cont3 = cont3;
    }

    public void setRank( String rank )
    {
        profile_rank = rank;
    }

    public Drawable getProfile()
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

    public String getCont()
    {
        return this.profile_cont;
    }

    public String getCont2()
    {
        return this.profile_cont2;
    }

    public String getCont3()
    {
        return this.profile_cont3;
    }

    public String getRank()
    {
        return this.profile_rank;
    }
}
