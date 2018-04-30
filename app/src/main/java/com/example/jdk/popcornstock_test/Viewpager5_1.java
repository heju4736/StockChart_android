package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.app.Fragment;
//import android.app.FragmentTransaction;
//import android.app.ListFragment;
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.graphics.Typeface;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.RequiresApi;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.TextView;
//
//import com.androidquery.AQuery;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//import static com.baobob.popcornstock.BackgroundLogin.nick_origin;
//import static com.baobob.popcornstock.BackgroundNickGet.nick_result;
//import static com.baobob.popcornstock.Intro.phoneNum;
//import static com.baobob.popcornstock.KakaoSignupActivity.kakaoProfile;
//
//public class Viewpager5_1 extends Fragment implements View.OnClickListener {
//
//    ImageButton nickEdit_btn;
//    CircleImageView nick_img;
//    Button img_btn, product_btn, read_btn;
//    TextView hp_text, nick_text;
//
//    AQuery aQuery;
//
//    public static Viewpager5_1 newInstance() {
//        return new Viewpager5_1();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_viewpager5_1, container, false);
//
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//        nickEdit_btn = (ImageButton) view.findViewById(R.id.nickEdit_Btn);
//        nick_img = (CircleImageView) view.findViewById(R.id.profile_img);
//        img_btn = (Button) view.findViewById(R.id.img_edit_Btn);
//        hp_text = (TextView) view.findViewById(R.id.hp_text);
//        nick_text = (TextView) view.findViewById(R.id.nick_text);
//        product_btn = (Button) view.findViewById(R.id.usingProduct_Btn);
//        product_btn.setOnClickListener(this);
//        read_btn = (Button) view.findViewById(R.id.readingList_Btn);
//        read_btn.setOnClickListener(this);
//
//        nick_text.setText(nick_origin);
//
//        hp_text = (TextView) view.findViewById(R.id.hp_text);
//
//        hp_text.setText(phoneNum);
//
//        String str_hp = hp_text.getText().toString();
//
//        String method = "nickGet";
//
//        BackgroundNickGet backgroundTask = new BackgroundNickGet(getActivity());
//        backgroundTask.execute( method, str_hp );
//
//        nick_text.setText(nick_result);
//
//
//        aQuery = new AQuery( getActivity() );
//        aQuery.id( nick_img ).image( kakaoProfile );
//
//        img_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent( getActivity(), Img_Expand.class );
//                startActivity(intent);
//            }
//        });
//
//        nickEdit_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), NickEdit.class);
//                startActivity(intent);
//            }
//        });
//
//        return view;
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    private void setChildFragment(Fragment child) {
//        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();
//
//        if (!child.isAdded()) {
//            childFt.replace(R.id.frag5, child);
//            childFt.addToBackStack(null);
//            childFt.commit();
//        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    @Override
//    public void onClick(View v) {
//
//        Fragment fragment;
//
//        switch (v.getId()) {
//            default:
//
//            case R.id.usingProduct_Btn: {
//                fragment = new Viewpager5_2();
//                setChildFragment(fragment);
//                break;
//            }
//
//            case R.id.readingList_Btn: {
//                fragment = new Viewpager5_3();
//                setChildFragment(fragment);
//                break;
//            }
//        }
//    }
//}
