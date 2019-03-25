package com.example.haeim.tshackathon2019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private static int timeout = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, BotActivity.class);
                startActivity(homeIntent);
                LottieAnimationView mLottie = findViewById(R.id.animation);
                mLottie.setAnimation("ticket.json");
                mLottie.playAnimation();
                mLottie.loop(true);
                finish();
            }
        }, timeout);
    }
}