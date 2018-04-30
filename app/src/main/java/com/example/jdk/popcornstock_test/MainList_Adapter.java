package com.example.jdk.popcornstock_test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Heeju on 2017-12-11.
 */

public class MainList_Adapter extends BaseAdapter {

    private ArrayList<MainList_Item> listViewItemList = new ArrayList<MainList_Item>();

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
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
            convertView = inflater.inflate(R.layout.mainlist_item, parent, false);
        }


        TextView txt3 = (TextView) convertView.findViewById(R.id.list_company);
        ImageButton btn = (ImageButton) convertView.findViewById(R.id.list_closebtn);


        MainList_Item listviewItem = listViewItemList.get(position);

        txt3.setText(listviewItem.getComeName());

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                listViewItemList.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public void addItem( String txt3 )
    {
        MainList_Item item = new MainList_Item();

        item.setComName(txt3);

        listViewItemList.add(item);
    }
}
