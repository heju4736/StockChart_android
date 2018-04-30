package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Viewpager5_3 extends Fragment {


    public static Viewpager5_3 newInstance() {
        return new Viewpager5_3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_viewpager5_3, container, false);

        android.app.FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Viewpager5_3List viewpgaer5_3 = new Viewpager5_3List();

        fragmentTransaction.add(R.id.readList, viewpgaer5_3);
        fragmentTransaction.commit();

        return view;
    }
}
