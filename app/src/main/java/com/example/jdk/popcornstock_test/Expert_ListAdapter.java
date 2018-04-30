package com.example.jdk.popcornstock_test;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heeju on 2017-12-11.
 */

public class Expert_ListAdapter extends BaseAdapter {

    private ArrayList<Expert_Item> list = new ArrayList<Expert_Item>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if( convertView == null )
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expert_listitem, parent, false);
        }

        TextView expertList_comName =(TextView) convertView.findViewById(R.id.expertList_comName);
        TextView expertList_nowPrice =(TextView) convertView.findViewById(R.id.expertList_nowPrice);
        TextView expertList_upDown =(TextView) convertView.findViewById(R.id.expertList_upDown);
        TextView expertList_fluctuation =(TextView) convertView.findViewById(R.id.expertList_fluctuation);
        TextView expertList_buyer =(TextView) convertView.findViewById(R.id.expertList_buyer);
        TextView expertList_targetPrice =(TextView) convertView.findViewById(R.id.expertList_targetPrice);
        TextView expertList_softy =(TextView) convertView.findViewById(R.id.expertList_softy);
        TextView expertList_code = (TextView) convertView.findViewById(R.id.code);

        Expert_Item listviewItem = (Expert_Item)this.getItem(position);

        expertList_comName.setText(listviewItem.getComeName());
        expertList_code.setText(listviewItem.getCode());
        expertList_nowPrice.setText(listviewItem.getnowPrice());
        expertList_upDown.setText(listviewItem.getup_Down());
        expertList_buyer.setText(listviewItem.getBuyer());
        expertList_fluctuation.setText(listviewItem.getFluctuation());
        expertList_targetPrice.setText(listviewItem.getTargetPrice());
        expertList_softy.setText(listviewItem.getSofty());

        String updown_img = expertList_upDown.getText().toString();

        if( updown_img == "▲")
        {
            expertList_upDown.setTextColor(Color.parseColor("#E64A45"));
        }

        else
        {
            expertList_upDown.setTextColor(Color.parseColor("#4B6BE3"));
        }

//        payment_Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return convertView;
    }

    public void addItem(String comName, String code, String nowPrice,  String upDown, String buyer, String fluctuation, String targetPrice, String softy) {

        Expert_Item item = new Expert_Item();

        item.setComName(comName);
        item.setCode(code);
        item.setnowPrice(nowPrice);
        item.setup_Down(upDown);
        item.setFluctuation(fluctuation);
        item.setBuyer(buyer);
        item.setTargetPrice(targetPrice);
        item.setSofty(softy);

        list.add(item);
    }
}
