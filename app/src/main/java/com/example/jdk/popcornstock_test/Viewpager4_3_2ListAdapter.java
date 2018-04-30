package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.content.Context;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.util.TypedValue;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class Viewpager4_3_2ListAdapter extends BaseAdapter {
//
//    private ArrayList<Viewpager4_3_2ListItem> listViewItemList = new ArrayList<Viewpager4_3_2ListItem>();
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
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.viewpager4_listitem, parent, false);
//
//        }
//
//        TextView comName = (TextView) convertView.findViewById(R.id.companyName);
//        final TextView rating_text = (TextView) convertView.findViewById(R.id.progress_text);
//        TextView percent_Number = (TextView) convertView.findViewById(R.id.percent_Number);
//        TextView comment1 = (TextView) convertView.findViewById(R.id.comment1);
//        TextView comment2 = (TextView) convertView.findViewById(R.id.comment2);
//        TextView comment3 = (TextView) convertView.findViewById(R.id.comment3);
//        //   Button jongmok_btn = (Button) convertView.findViewById(R.id.jong_Btn);
//        final ImageView rating_bar = (ImageView) convertView.findViewById(R.id.progress_bar);
//
//        Viewpager4_3_2ListItem listviewItem = listViewItemList.get(position);
//
//        comName.setText(listviewItem.getName());
//        percent_Number.setText(listviewItem.getNumber());
//        comment1.setText(listviewItem.getComent1());
//        comment2.setText(listviewItem.getComent2());
//        comment3.setText(listviewItem.getComent3());
//        rating_text.setText(listviewItem.getIcon());
//
//        rating_text.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                rating_bar.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String str_rating = rating_text.getText().toString();
//                int rating = Integer.parseInt(str_rating);
//
//
//
//                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)rating_bar.getLayoutParams();
//                lp.gravity = Gravity.LEFT;
//
//                switch (rating)
//                {
//
//                    case 1 :
//                        int px = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, rating * 14, context.getResources().getDisplayMetrics());
//                        rating_bar.getLayoutParams().width = px;
//                        break;
//
//                    case 2 :
//                        int px2 = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, rating * 14, context.getResources().getDisplayMetrics());
//                        rating_bar.getLayoutParams().width = px2;
//                        break;
//
//                    case 3 :
//                        int px3 = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, rating * 14, context.getResources().getDisplayMetrics());
//                        rating_bar.getLayoutParams().width = px3;
//                        break;
//
//                    case 4 :
//                        int px4 = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, rating * 14, context.getResources().getDisplayMetrics());
//                        rating_bar.getLayoutParams().width = px4;
//                        break;
//
//                    case 5 :
//                        int px5 = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, rating * 14, context.getResources().getDisplayMetrics());
//                        rating_bar.getLayoutParams().width = px5;
//                        break;
//
//                }
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                notifyDataSetChanged();
//            }
//        });
//
//        return convertView;
//    }
//
//
//    public void addItem(String num, String name, String number, String coment1, String coment2, String coment3) {
//        Viewpager4_3_2ListItem item = new Viewpager4_3_2ListItem();
//
//        item.setIcon(num);
//        item.setName(name);
//        item.setNumber(number);
//        item.setComent1(coment1);
//        item.setComent2(coment2);
//        item.setComent3(coment3);
//
//        listViewItemList.add(item);
//    }
//}
