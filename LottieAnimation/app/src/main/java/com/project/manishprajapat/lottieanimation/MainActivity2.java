package com.project.manishprajapat.lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    LottieAnimationView animationView;
    TextView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button=findViewById(R.id.button);
        animationView = findViewById(R.id.anim);


    }

    public void getAnim(View view) {

        animationView.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        animationView.playAnimation();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(getApplication(),MainActivity3.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();

    }
}
