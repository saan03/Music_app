package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity3 extends AppCompatActivity {

    private boolean isButtonClicked = false;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mediaPlayer = MediaPlayer.create(this, R.raw.sanna); // Replace with your audio file in the raw folder

        ImageButton start3 = findViewById(R.id.b3);
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the state
                isButtonClicked = !isButtonClicked;

                // Change the button image based on the state
                if (isButtonClicked) {
                    start3.setBackgroundResource(R.drawable.bpp);
                    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                    }
                } else {
                    start3.setBackgroundResource(R.drawable.bp);
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0); // Stop and reset the audio to the beginning
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Release the media player when the activity is destroyed
        }
    }
}


