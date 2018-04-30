package com.example.jdk.popcornstock_test;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Heeju on 2017-12-05.
 */

public class Fragment4 extends Fragment{

    Button btn1, btn2, btn3, btn4, btn5;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment4, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        btn1 = (Button) view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Bottombar.class);
                startActivity(intent);
            }
        });

        btn2 = (Button) view.findViewById(R.id.btn2);

        btn3 = (Button) view.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment;

                fragment = new Viewpager4_3();
                setChildFragment(fragment);
            }
        });

        btn4 = (Button) view.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment;

                fragment = new Viewpager4_3_2();
                setChildFragment(fragment);
            }
        });

        btn5 = (Button) view.findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment;

                fragment = new Viewpager3_1();
                setChildFragment(fragment);
            }
        });
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setChildFragment(Fragment child) {

        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        childFt.replace(R.id.frag4_1, child);
        childFt.addToBackStack(null);
        childFt.commit();
    }


//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    @Override
//    public void onClick(View v) {
//
//        Fragment fragment;
//
//        FragmentManager fm = getActivity().getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        switch(v.getId())
//        {
//            case R.id.btn1:
//                Intent intent = new Intent(getActivity(), Bottombar.class);
//                startActivity(intent);
//                break;
//
//            case R.id.btn2:
//                break;
//
//            case R.id.btn3:
//                fragment = new Viewpager4_3();
//                setChildFragment(fragment);
//                break;
//
//            case R.id.btn4:
//                Viewpager4_3_2 viewpager4_3_2 = new Viewpager4_3_2();
//                ft.replace(R.id.frag4_1, viewpager4_3_2);
//                ft.commit();
//                break;
//
//            case R.id.btn5:
//                fragment = new Viewpager3_1();
//                setChildFragment(fragment);
//                break;
//        }
//    }

}