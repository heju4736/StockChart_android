package com.example.jdk.popcornstock_test;

import android.graphics.drawable.Drawable;

/**
 * Created by Heeju on 2017-12-11.
 */

public class Viewpager4_ListItem {

    private String rating_bar;
    private String company_name;
    private String company_num;
    private String company_coment1;
    private String company_coment2;
    private String company_coment3;

    public void setIcon( String icon )
    {
        rating_bar = icon;
    }

    public void setName( String comName )
    {
        company_name = comName;
    }

    public void setNumber( String comNum )
    {
        company_num = comNum;
    }

    public void setComent1( String comComent1 )
    {
        company_coment1 = comComent1;
    }

    public void setComent2( String comComent2 )
    {
        company_coment2 = comComent2;
    }

    public void setComent3( String comComent3 )
    {
        company_coment3 = comComent3;
    }


    public String getIcon()
    {
        return this.rating_bar;
    }

    public String getName()
    {
        return this.company_name;
    }

    public String getNumber()
    {
        return this.company_num;
    }

    public String getComent1()
    {
        return this.company_coment1;
    }

    public String getComent2()
    {
        return this.company_coment2;
    }

    public String getComent3()
    {
        return this.company_coment3;
    }

}
