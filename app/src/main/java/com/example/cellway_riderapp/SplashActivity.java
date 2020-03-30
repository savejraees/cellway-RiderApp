package com.example.cellway_riderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = (ImageView) findViewById(R.id.imageView1);
        Animation an2 = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        imageView.startAnimation(an2);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

//                if (AppStatus.getInstance(SplashActivity.this).isOnline()) {
//                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(i);
//                    finish();
//
//                    //           Toast.makeText(this,"You are online!!!!",Toast.LENGTH_LONG).show();
//
//                }
//                else {
//
//                    ContextThemeWrapper ctw = new ContextThemeWrapper(SplashActivity.this, R.style.Theme_AlertDialog);
//                    final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(ctw);
//                    alertDialogBuilder.setTitle("No internet connection");
//                    alertDialogBuilder.setMessage("Check your  internet connection or try again");
//                    alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//
//                        }
//                    });
//                    alertDialogBuilder.show();
//                }

            }
        }, SPLASH_TIME_OUT);
    } }