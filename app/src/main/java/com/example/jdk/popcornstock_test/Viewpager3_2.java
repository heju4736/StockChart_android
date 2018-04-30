package com.example.jdk.popcornstock_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;
import static com.example.jdk.popcornstock_test.Intro.phoneNum;

public class Viewpager3_2 extends Fragment {

    CheckBox check_high, check_row, check_many, check_little, check_human, check_robot;
    ImageButton search_btn, delete_btn, cancel_btn;
    EditText rankEdit;
    TextView rank_phone;

    static String rankNick="";
    static String str_suik, str_gudok, str_expert, phone;

    String suik = "";
    String gudok = "";
    String expert = "";



    static int suik_num = 0;
    static int gudok_num = 0;
    static int expert_num = 0;

    boolean a = false;
    boolean b = false;
    boolean c = false;
    boolean d = false;
    boolean e = false;
    boolean f = false;


    public static Viewpager3_2 newInstance() {
        return new Viewpager3_2();
    }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.activity_viewpager3_2, container, false);

            check_high = (CheckBox) view.findViewById(R.id.high_checkBox);
            check_row = (CheckBox) view.findViewById(R.id.row_checkBox);
            check_many = (CheckBox) view.findViewById(R.id.many_checkBox);
            check_little = (CheckBox) view.findViewById(R.id.little_checkBox);
            check_human = (CheckBox) view.findViewById(R.id.human_checkBox);
            check_robot = (CheckBox) view.findViewById(R.id.robot_checkBox);
            search_btn = (ImageButton) view.findViewById(R.id.rankSearch_btn);
            rankEdit = (EditText) view.findViewById(R.id.rankEdit);
            delete_btn = (ImageButton) view.findViewById(R.id.rankDelete_btn);
            cancel_btn = (ImageButton) view.findViewById(R.id.rankCancel_btn);
            rank_phone = (TextView) view.findViewById(R.id.rank_phone);

            rank_phone.setText(phoneNum);
            rank_phone.setVisibility(GONE);


            delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankEdit.setText(null);
                }
            });

            check_high.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if( a == false) {

                        a = true;
                        b = false;
                        c = false;
                        d = false;
                        check_row.setChecked(false);
                        check_little.setChecked(false);
                        check_many.setChecked(false);
                        suik = "a";
                        gudok = "";
                    }

                    else {
                        a = false;

                        check_high.setChecked(false);
                        suik = "";
                    }

                }
            });

            check_row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if( b == false) {

                        a = false;
                        b = true;
                        c = false;
                        d = false;

                        check_high.setChecked(false);
                        check_little.setChecked(false);
                        check_many.setChecked(false);

                        suik = "aa";
                        gudok = "";
                    }

                    else {

                        b = false;

                        check_row.setChecked(false);

                        suik = "";

                    }
                }
            });

            check_many.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if( c == false) {

                        a = false;
                        b = false;
                        c = true;
                        d = false;

                        check_little.setChecked(false);
                        check_high.setChecked(false);
                        check_row.setChecked(false);

                        gudok = "a";
                        gudok = "";
                    }

                    else {

                        c = false;

                        check_many.setChecked(false);

                        suik = "";
                    }
                }
            });

            check_little.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if( d == false) {

                        a = false;
                        b = false;
                        c = false;
                        d = true;

                        check_many.setChecked(false);
                        check_high.setChecked(false);
                        check_row.setChecked(false);
                        gudok = "aa";
                        gudok = "";
                    }

                    else {

                        d = false;

                        check_little.setChecked(false);

                        suik = "";
                    }
                }
            });

            check_human.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if( e == false) {

                        e = true;
                        check_robot.setChecked(false);
                        expert = "a";
                    }

                    else {
                        e = false;
                        check_human.setChecked(false);
                        expert = "";
                    }
                }
            });

            check_robot.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if( f == false) {

                        f = true;
                        check_human.setChecked(false);
                        expert = "aa";
                    }

                    else {
                        f = false;
                        check_robot.setChecked(false);
                        expert = "";
                    }
                }
            });



            search_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    suik_num = suik.length();
                    gudok_num = gudok.length();
                    expert_num = expert.length();

                    str_suik = String.valueOf(suik_num);
                    str_gudok = String.valueOf(gudok_num);
                    str_expert = String.valueOf(expert_num);

                    rankNick = rankEdit.getText().toString();
                    phone = rank_phone.getText().toString();

                    String type = "rank_data";

                    BackgroundRank backgroundWorker = new BackgroundRank(getActivity());
                    backgroundWorker.execute(type, str_suik, str_gudok, str_expert, rankNick, phone);

                    FragmentManager fm = getActivity().getFragmentManager();
                    fm.beginTransaction().replace(R.id.frag3, new Viewpager3_1()).commit();
                }
            });


            return view;
    }

}
