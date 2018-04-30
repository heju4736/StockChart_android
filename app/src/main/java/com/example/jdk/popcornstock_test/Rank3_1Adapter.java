package com.example.jdk.popcornstock_test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Heeju on 2017-12-11.
 */

public class Rank3_1Adapter extends BaseAdapter {

    private ArrayList<Rank3_1Item> listViewItemList = new ArrayList<Rank3_1Item>();

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

        if( convertView == null )
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview3_1item, parent, false);
        }

     //   CircleImageView icon = (CircleImageView) convertView.findViewById(R.id.img3_1);
        TextView nick = (TextView) convertView.findViewById(R.id.id3_1);
        TextView content = (TextView) convertView.findViewById(R.id.text13_1);
        TextView content2 = (TextView) convertView.findViewById(R.id.text23_1);
        TextView content3 = (TextView) convertView.findViewById(R.id.text33_1);
        TextView content4 = (TextView) convertView.findViewById(R.id.text43_1);
        TextView rank = (TextView) convertView.findViewById(R.id.num3_1);
//        TextView txt1 = (TextView) convertView.findViewById(R.id.ranktxt1);
//        TextView txt2 = (TextView) convertView.findViewById(R.id.ranktxt2);
//        TextView txt3 = (TextView) convertView.findViewById(R.id.ranktxt3);

        Rank3_1Item listviewItem = listViewItemList.get(position);

    //    icon.setImageURI(listviewItem.getProfile());
        nick.setText(listviewItem.getNick());
        content.setText(listviewItem.getContent());
        content2.setText(listviewItem.getContent2());
        content3.setText(listviewItem.getContent3());
        content4.setText(listviewItem.getContent4());
//        txt1.setText(listviewItem.getCont());
//        txt2.setText(listviewItem.getCont2());
//        txt3.setText(listviewItem.getCont3());
        rank.setText(listviewItem.getRank());

        return convertView;
    }

    public void addItem( String pro_nick, String pro_content, String pro_content2, String pro_content3, String pro_content4,String pro_rank )
    {
        Rank3_1Item item = new Rank3_1Item();

//        item.setIcon(profile);
        item.setNick(pro_nick);
        item.setCotent(pro_content);
        item.setCotent2(pro_content2);
        item.setCotent3(pro_content3);
        item.setCotent4(pro_content4);
//        item.setCont(txt1);
//        item.setCont2(txt2);
//        item.setCont3(txt3);
        item.setRank(pro_rank);

        listViewItemList.add(item);
    }

    public void Clear(){
        listViewItemList.clear();
    }

}
