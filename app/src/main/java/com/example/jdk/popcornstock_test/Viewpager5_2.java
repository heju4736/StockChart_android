package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Viewpager5_2 extends Fragment {

    public static Viewpager5_2 newInstance() {
        return new Viewpager5_2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_viewpager5_2, container, false);

        android.app.FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Viewpager5_2List viewpgaer5_2 = new Viewpager5_2List();

        fragmentTransaction.add(R.id.productList, viewpgaer5_2);
        fragmentTransaction.commit();

        return view;
    }



}
