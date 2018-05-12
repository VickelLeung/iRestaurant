package com.example.vicke.irestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //timer for splash
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove actionbar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent MainIntent = new Intent(MainActivity.this, LoginActivity.class);
               startActivity(MainIntent);
               finish();
           }
       },SPLASH_DISPLAY_LENGTH);

        }

}
