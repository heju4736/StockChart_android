package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Heeju on 2017-12-05.
 */

public class Fragment2 extends Fragment implements View.OnClickListener {

    TextView text1, text2;
    Button frag2_1btn, frag2_2btn;

    public static Fragment2 newInstance()
    {
        return new Fragment2();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.layout_fragment2, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Viewpager2_1 viewpgaer2_1 = new Viewpager2_1();

        fragmentTransaction.add(R.id.frag2, viewpgaer2_1);
        fragmentTransaction.commit();

        text1 = (TextView) view.findViewById(R.id.text2_1);
        text2 = (TextView) view.findViewById(R.id.text2_2);

        frag2_1btn = (Button) view.findViewById(R.id.frag2_1btn);
        frag2_1btn.setOnClickListener(this);
        frag2_2btn = (Button) view.findViewById(R.id.frag2_2btn);
        frag2_2btn.setOnClickListener(this);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {

        Fragment fragment;

        switch (v.getId())
        {
            case R.id.frag2_1btn:
                fragment = new Viewpager2_1();
                setChildFragment(fragment);
                break;

            case R.id.frag2_2btn:
                fragment = new Viewpager2_2();
                setChildFragment(fragment);
                break;
        }

    }

    //error나면 여기보기
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setChildFragment(Fragment child) {

        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if(!child.isAdded()) {
            childFt.replace(R.id.frag2, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }
}