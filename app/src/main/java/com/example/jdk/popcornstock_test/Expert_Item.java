package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Heeju on 2018-02-12.
 */

public class Expert_Item {

    private String comeName, nowPrice, up_Down, Fluctuation, Buyer, targetPrice, Softy, Code;

    public void setComName (String comname)
    {
        comeName = comname;
    }

    public void setnowPrice (String nowprice)
    {
        nowPrice = nowprice;
    }

    public void setup_Down (String up_down)
    {
        up_Down = up_down;
    }

    public void setFluctuation (String buyer)
    {
        Buyer = buyer;
    }

    public void setCode (String code)
    {
        Code = code;
    }

    public void setBuyer (String fluctuation)
    {
        Fluctuation = fluctuation;
    }

    public void setTargetPrice (String targetprice)
    {
        targetPrice = targetprice;
    }

    public void setSofty (String softy)
    {
        Softy = softy;
    }

    public String getComeName()
    {
        return this.comeName;
    }

    public String getCode()
    {
        return this.Code;
    }

    public String getnowPrice()
    {
        return this.nowPrice;
    }

    public String getup_Down()
    {
        return this.up_Down;
    }

    public String getFluctuation()
    {
        return this.Fluctuation;
    }

    public String getBuyer()
    {
        return this.Buyer;
    }

    public String getTargetPrice()
    {
        return this.targetPrice;
    }

    public String getSofty()
    {
        return this.Softy;
    }

}
