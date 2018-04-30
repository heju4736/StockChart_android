package com.example.jdk.popcornstock_test;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Viewpager3_4 extends ListFragment {

    public static Viewpager3_4 newInstance() {
        return new Viewpager3_4();
    }

    Rank3_2Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        adapter = new Rank3_2Adapter();
        setListAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop1), "바오오오오밥", "999 ", " 신생 ", " 신규랭킹 1위 ", "인공지능" , " 737.09% ","|", "|", "|");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop2), "허니팝콘", "123 ", "", " 신규랭킹 2위 ", " 인공지능 " , " 737.00% ", "|", "", "|");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop3), "치즈팝콘", "5 ", "", " 신규랭킹 3위 ", "" , " 715.09% ", "|", "", "");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop4), "팝콘스탁", "88 ", " 신생 ", "", "" , " 701.09% ", "|", "", "");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop1), "바오밥솔루션", "101 ", "", " 주간랭킹 2위 ", "" , " 687.09% ", "|", "", "");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop2), "바오바오바오밥", "1K ", " 신생 ", "", " 인공지능 " , " 650.09% ", "|", "", "|");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.icon_pop3), "바바바밥", "106 ", "", " 신규랭킹 7위 ", "" , " 701.09% ", "|", "", "");

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
