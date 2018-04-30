package com.example.jdk.popcornstock_test;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Viewpager5_3List extends ListFragment {

    Viewpager5Read_ListAdapter adapter;

    public static Viewpager5_3List newInstance() {
        return new Viewpager5_3List();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        adapter = new Viewpager5Read_ListAdapter();
        setListAdapter(adapter);

        adapter.addItem("아아아아아아");
        adapter.addItem("어어어어어어어");
        adapter.addItem("가ㅣ가가가간어ㅣㅓㅇ하ㅣ엏ㄴ");

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
