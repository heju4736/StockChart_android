package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class Viewpager2_2 extends Fragment {

    CheckBox checkbox1_1, checkbox1_2, checkbox1_3, checkbox1_4, checkbox1_5;
    CheckBox checkbox2_1, checkbox2_2, checkbox2_3, checkbox2_4, checkbox2_5;
    CheckBox checkbox3_1, checkbox3_2, checkbox3_3, checkbox3_4, checkbox3_5;
    CheckBox checkbox4_1, checkbox4_2, checkbox4_3, checkbox4_4, checkbox4_5;

    ImageButton jongmok2_btn;

    String str_goldegg = "";
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;

    static String goldegg;
    static String strpower;
    static String strsupply;
    static String strperfomance;

    static String value = "메롱";

    public Viewpager2_2()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.activity_viewpager2_2, container, false);

        jongmok2_btn = (ImageButton) view.findViewById(R.id.jongmok2_btn);

        checkbox2_1 = (CheckBox) view.findViewById(R.id.checkbox2_1);
        checkbox2_2 = (CheckBox) view.findViewById(R.id.checkbox2_2);
        checkbox2_3 = (CheckBox) view.findViewById(R.id.checkbox2_3);
        checkbox2_4 = (CheckBox) view.findViewById(R.id.checkbox2_4);
        checkbox2_5 = (CheckBox) view.findViewById(R.id.checkbox2_5);

        checkbox3_1 = (CheckBox) view.findViewById(R.id.checkbox3_1);
        checkbox3_2 = (CheckBox) view.findViewById(R.id.checkbox3_2);
        checkbox3_3 = (CheckBox) view.findViewById(R.id.checkbox3_3);
        checkbox3_4 = (CheckBox) view.findViewById(R.id.checkbox3_4);
        checkbox3_5 = (CheckBox) view.findViewById(R.id.checkbox3_5);

        checkbox4_1 = (CheckBox) view.findViewById(R.id.checkbox4_1);
        checkbox4_2 = (CheckBox) view.findViewById(R.id.checkbox4_2);
        checkbox4_3 = (CheckBox) view.findViewById(R.id.checkbox4_3);
        checkbox4_4 = (CheckBox) view.findViewById(R.id.checkbox4_4);
        checkbox4_5 = (CheckBox) view.findViewById(R.id.checkbox4_5);

        checkbox1_1 = (CheckBox) view.findViewById(R.id.checkbox1_1);
        checkbox1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a == false)
                {
                    a = true;
                    b = false;
                    c = false;
                    d = false;
                    e = false;

                    checkbox1_2.setChecked(false);
                    checkbox1_3.setChecked(false);
                    checkbox1_4.setChecked(false);
                    checkbox1_5.setChecked(false);
                }

                else {
                    a = false;

                    checkbox1_1.setChecked(false);
                }

            }
        });

        checkbox1_2 = (CheckBox) view.findViewById(R.id.checkbox1_2);
        checkbox1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (b == false)
                {
                    b = true;
                    a = false;
                    c = false;
                    d = false;
                    e = false;

                    checkbox1_1.setChecked(false);
                    checkbox1_3.setChecked(false);
                    checkbox1_4.setChecked(false);
                    checkbox1_5.setChecked(false);
                }

                else {
                    b = false;

                    checkbox1_2.setChecked(false);
                }
            }
        });

        checkbox1_3 = (CheckBox) view.findViewById(R.id.checkbox1_3);
        checkbox1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (c == false)
                {
                    c = true;
                    a = false;
                    b = false;
                    d = false;
                    e = false;

                    checkbox1_2.setChecked(false);
                    checkbox1_1.setChecked(false);
                    checkbox1_4.setChecked(false);
                    checkbox1_5.setChecked(false);
                }

                else {
                    c = false;

                    checkbox1_3.setChecked(false);
                }
            }
        });

        checkbox1_4 = (CheckBox) view.findViewById(R.id.checkbox1_4);
        checkbox1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (d == false)
                {
                    d = true;
                    a = false;
                    b = false;
                    c = false;
                    e = false;

                    checkbox1_2.setChecked(false);
                    checkbox1_3.setChecked(false);
                    checkbox1_1.setChecked(false);
                    checkbox1_5.setChecked(false);
                }

                else {
                    d = false;

                    checkbox1_4.setChecked(false);
                }
            }
        });

        checkbox1_5 = (CheckBox) view.findViewById(R.id.checkbox1_5);
        checkbox1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (e == false)
                {
                    e = true;
                    a = false;
                    b = false;
                    c = false;
                    d = false;

                    checkbox1_2.setChecked(false);
                    checkbox1_3.setChecked(false);
                    checkbox1_4.setChecked(false);
                    checkbox1_1.setChecked(false);
                }

                else {
                    e = false;

                    checkbox1_5.setChecked(false);
                }
            }
        });

        jongmok2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goldegg = "5";

                if(checkbox1_1.isChecked()) goldegg  = "1";
                if(checkbox1_2.isChecked()) goldegg  = "2";
                if(checkbox1_3.isChecked()) goldegg  = "3";
                if(checkbox1_4.isChecked()) goldegg  = "4";
                if(checkbox1_5.isChecked()) goldegg  = "5";

                strpower = "";

                if(checkbox2_1.isChecked()) strpower += "1";
                else strpower += "0";

                if(checkbox2_2.isChecked()) strpower += "1";
                else strpower += "0";

                if(checkbox2_3.isChecked()) strpower += "1";
                else strpower += "0";

                if(checkbox2_4.isChecked()) strpower += "1";
                else strpower += "0";

                if(checkbox2_5.isChecked()) strpower += "1";
                else strpower += "0";

                strsupply = "";

                if(checkbox3_1.isChecked()) strsupply += "1";
                else strsupply += "0";

                if(checkbox3_2.isChecked()) strsupply += "1";
                else strsupply += "0";

                if(checkbox3_3.isChecked()) strsupply += "1";
                else strsupply += "0";

                if(checkbox3_4.isChecked()) strsupply += "1";
                else strsupply += "0";

                if(checkbox3_5.isChecked()) strsupply += "1";
                else strsupply += "0";

                strperfomance = "";

                if(checkbox4_1.isChecked()) strperfomance += "1";
                else strperfomance += "0";

                if(checkbox4_2.isChecked()) strperfomance += "1";
                else strperfomance += "0";

                if(checkbox4_3.isChecked()) strperfomance += "1";
                else strperfomance += "0";

                if(checkbox4_4.isChecked()) strperfomance += "1";
                else strperfomance += "0";

                if(checkbox4_5.isChecked()) strperfomance += "1";
                else strperfomance += "0";

                value = "메롱";
                String type = "jongmok";

                BackgroundJongmokSearch backgroundJongmokSearch = new BackgroundJongmokSearch(getActivity());
                backgroundJongmokSearch.execute(type, goldegg, strpower, strsupply, strperfomance, value);

                FragmentManager fm = getActivity().getFragmentManager();
                fm.beginTransaction().replace(R.id.frag2, new Viewpager2_1()).commit();
            }
        });




        return view;
    }

    public static Viewpager2_2 newInstance() {
        return new Viewpager2_2();
    }

}
