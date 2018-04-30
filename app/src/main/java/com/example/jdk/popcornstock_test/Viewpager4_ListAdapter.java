package com.example.jdk.popcornstock_test;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.view.PagerAdapter.POSITION_NONE;

public class Viewpager4_ListAdapter extends BaseAdapter {

    private ArrayList<Viewpager4_ListItem> listViewItemList = new ArrayList<Viewpager4_ListItem>();

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
            convertView = inflater.inflate(R.layout.viewpager4_listitem, parent, false);

        }

        TextView comName = (TextView) convertView.findViewById(R.id.companyName);
        final TextView rating_text = (TextView) convertView.findViewById(R.id.progress_text);
        TextView percent_Number = (TextView) convertView.findViewById(R.id.percent_Number);
        TextView comment1 = (TextView) convertView.findViewById(R.id.comment1);
        TextView comment2 = (TextView) convertView.findViewById(R.id.comment2);
        TextView comment3 = (TextView) convertView.findViewById(R.id.comment3);
        ImageButton jongmok_btn = (ImageButton) convertView.findViewById(R.id.jong_Btn);
        final ImageView rating_bar = (ImageView) convertView.findViewById(R.id.progress_bar);

        Viewpager4_ListItem listviewItem = listViewItemList.get(position);

        rating_text.setText(listviewItem.getIcon());
        comName.setText(listviewItem.getName());
        percent_Number.setText(listviewItem.getNumber());
        comment1.setText(listviewItem.getComent1());
        comment2.setText(listviewItem.getComent2());
        comment3.setText(listviewItem.getComent3());

        rating_bar.setVisibility(View.VISIBLE);

        String str_rating = rating_text.getText().toString();
        int rating = Integer.parseInt(str_rating);

        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)rating_bar.getLayoutParams();
        lp.gravity = Gravity.LEFT;

        int px = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, rating * 14, context.getResources().getDisplayMetrics());

        switch( rating )
        {
            case 1:
                rating_bar.getLayoutParams().width = px;
                break;

            case 2:
                rating_bar.getLayoutParams().width = px;
                break;

            case 3:
                rating_bar.getLayoutParams().width = px;
                break;

            case 4:
                rating_bar.getLayoutParams().width = px;
                break;

            case 5:
                rating_bar.getLayoutParams().width = px;
                break;
        }

        jongmok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Bottombar.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }


    public void addItem(String num, String name, String number, String coment1, String coment2, String coment3) {
        Viewpager4_ListItem item = new Viewpager4_ListItem();

        item.setIcon(num);
        item.setName(name);
        item.setNumber(number);
        item.setComent1(coment1);
        item.setComent2(coment2);
        item.setComent3(coment3);

        listViewItemList.add(item);
    }

    public void Clear(){
        listViewItemList.clear();
    }
}
