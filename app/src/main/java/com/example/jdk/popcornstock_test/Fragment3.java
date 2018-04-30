package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Heeju on 2017-12-05.
 */

public class Fragment3 extends Fragment implements View.OnClickListener{

    TextView text1, text2;
    Button frag3_1btn, frag3_2btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_fragment3, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        android.app.FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Viewpager3_1 viewpgaer3_1 = new Viewpager3_1();

        fragmentTransaction.add(R.id.frag3, viewpgaer3_1);
        fragmentTransaction.commit();

        text1 = (TextView) rootView.findViewById(R.id.text3_1);
        text2 = (TextView) rootView.findViewById(R.id.text3_2);
        frag3_1btn = (Button) rootView.findViewById(R.id.frag3_1btn);
        frag3_2btn = (Button) rootView.findViewById(R.id.frag3_2btn);

        frag3_1btn.setOnClickListener(this);
        frag3_2btn.setOnClickListener(this);

        return rootView;
    }

    public static Fragment3 newInstance() {
        return new Fragment3();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) {
            childFt.replace(R.id.frag3, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {

        Fragment fragment;

        switch (v.getId()) {
            default:

            case R.id.frag3_1btn: {
                fragment = new Viewpager3_1();
                setChildFragment(fragment);
                text1.setTypeface(null, Typeface.BOLD);
                text2.setTypeface(null, Typeface.NORMAL);
                break;
            }

            case R.id.frag3_2btn: {
                fragment = new Viewpager3_2();
                setChildFragment(fragment);
                text2.setTypeface(null, Typeface.BOLD);
                text1.setTypeface(null, Typeface.NORMAL);
                break;
            }
        }
    }
}