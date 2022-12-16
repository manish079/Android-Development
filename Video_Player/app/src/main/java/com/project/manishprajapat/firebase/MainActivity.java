package com.project.manishprajapat.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vw = findViewById(R.id.videoView);

        vw.setVideoPath("android.resource://"+ getPackageName()+"/" +R.raw.de);
        MediaController mediaController = new MediaController(this);
         vw.setMediaController(mediaController);
         mediaController.setAnchorView(vw);

        vw.start();
    }
}