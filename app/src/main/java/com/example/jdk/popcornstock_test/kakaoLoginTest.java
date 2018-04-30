package com.example.jdk.popcornstock_test;//package com.baobob.popcornstock;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.androidquery.AQuery;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//import static com.baobob.popcornstock.KakaoSignupActivity.kakaoEmail;
//import static com.baobob.popcornstock.KakaoSignupActivity.kakaoId;
//import static com.baobob.popcornstock.KakaoSignupActivity.kakaoNickname;
//import static com.baobob.popcornstock.KakaoSignupActivity.kakaoProfile;
//
//public class kakaoLoginTest extends AppCompatActivity {
//
//    CircleImageView kakao_profile;
//    TextView nick;
//    TextView email;
//    TextView kakao_id;
//
//    AQuery aQuery;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_kakao_login_test);
//
//        aQuery = new AQuery(this );
//
//        nick = (TextView) findViewById(R.id.user_nickname);
//        kakao_id = (TextView) findViewById(R.id.user_id);
//        email = (TextView) findViewById(R.id.user_email);
//        kakao_profile = (CircleImageView) findViewById(R.id.user_img);
//
//        aQuery.id( kakao_profile ).image( kakaoProfile );
//
//        nick.setText(kakaoNickname);
//        kakao_id.setText(kakaoId);
//        email.setText(kakaoEmail);
//
//    }
//}
