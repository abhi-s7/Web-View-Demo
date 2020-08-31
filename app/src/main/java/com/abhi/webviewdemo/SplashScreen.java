package com.abhi.webviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.abhi.webviewdemo.R;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener{

    public static int SPLASH_TIME_OUT = 3000;
    protected Animation fadeIn;
    protected ImageView img1;

//    protected TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fadein);         //animation for image_view

//        txt1 = findViewById(R.id.splashText);
//        txt1.setVisibility(View.VISIBLE);
//        txt1.startAnimation(fadeIn);

        img1 = findViewById(R.id.imageView);
        img1.setVisibility(View.VISIBLE);
        img1.startAnimation(fadeIn);
        new Handler().postDelayed(new Runnable(){
            public void run(){                                         //delay for screen
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();                                                        //to end the activity
                //    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
