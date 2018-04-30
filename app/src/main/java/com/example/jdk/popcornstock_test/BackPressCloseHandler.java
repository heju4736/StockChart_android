package com.example.jdk.popcornstock_test;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Heeju on 2018-01-29.
 */

public class BackPressCloseHandler {

    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler( Activity context )
    {
        this.activity = context;
    }

    public void onBackPressed()
    {
        if( System.currentTimeMillis() > backKeyPressedTime + 2000)
        {
            backKeyPressedTime = System.currentTimeMillis();
            showToast();
            return;
        }

        if( System.currentTimeMillis() <= backKeyPressedTime + 2000 )
        {
            toast.cancel();

            Intent intent = new Intent(activity, Login.class);
            activity.startActivity(intent);

            activity.moveTaskToBack( true );
            activity.finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    public void showToast()
    {
        toast = Toast.makeText(activity, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();

    }
}
