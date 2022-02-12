package com.goNet.gonet;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.goNet.gonet.secondactivity.view.secondActivity;

public class MainActivity extends AppCompatActivity {

    private  MediaPlayer song1 = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LottieAnimationView animationView= findViewById(R.id.splash);



        song1 = MediaPlayer.create(getApplicationContext(),  R.raw.netflixsound);
        song1.setLooping(false);
        animationView.addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                            song1.start();


                        });
        animationView.playAnimation();

        if (animationView.isAnimating()) {

        }else
        {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    song1.pause();
                    goToLoginContainer();

                }
            },4000);
        }
    }
    private void goToLoginContainer() {
        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }
}