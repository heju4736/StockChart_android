package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Viewpager4_3 extends Fragment{

    ImageButton img_Btn1, img_Btn2;
    ImageView img1, img2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_viewpager4_3, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Viewpager4_3_1 viewpager4_3_1 = new Viewpager4_3_1();

        fragmentTransaction.add(R.id.frag4, viewpager4_3_1);
        fragmentTransaction.commit();

        return view;
    }

}
