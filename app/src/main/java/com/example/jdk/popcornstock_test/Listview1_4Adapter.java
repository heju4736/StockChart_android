package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
///**
// * Created by Heeju on 2017-12-11.
// */
//
//public class Listview1_4Adapter extends BaseAdapter {
//
//    private ArrayList<Listview1_4Item> listViewItemList = new ArrayList<Listview1_4Item>();
//
//    @Override
//    public int getCount() {
//        return listViewItemList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return listViewItemList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        final int pos = position;
//        final Context context = parent.getContext();
//
//        if( convertView == null )
//        {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.listview1_4item, parent, false);
//        }
//
//        TextView news_title = (TextView) convertView.findViewById(R.id.news_title);
//        TextView news_reporter = (TextView) convertView.findViewById(R.id.news_reporter);
//        TextView news_time = (TextView) convertView.findViewById(R.id.news_time);
//
//        Listview1_4Item listviewItem = listViewItemList.get(position);
//
//        news_title.setText(listviewItem.getTitle());
//        news_reporter.setText(listviewItem.getReporter());
//        news_time.setText(listviewItem.getTime());
//
//        return convertView;
//    }
//
//    public void addItem( String news_title, String news_reporter, String news_time )
//    {
//        Listview1_4Item item = new Listview1_4Item();
//
//        item.setTitle(news_title);
//        item.setReporter(news_reporter);
//        item.setTime(news_time);
//
//        listViewItemList.add(item);
//    }
//}
