package com.example.jdk.popcornstock_test;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Viewpager5Pro_ListAdapter extends BaseAdapter {

    private ArrayList<Viewpager5_ListItem> listViewItemList = new ArrayList<Viewpager5_ListItem>();

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
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.viewpager5_listitem, parent, false);

        }

        TextView coment = (TextView) convertView.findViewById(R.id.frag5_listcoment);

        Viewpager5_ListItem listviewItem = listViewItemList.get(position);

        coment.setText(listviewItem.getContent());

        return convertView;
    }


    public void addItem(String num) {

        Viewpager5_ListItem item = new Viewpager5_ListItem();

        item.setContent(num);

        listViewItemList.add(item);
    }
}
