package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageButton playbutton,pausebutton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbutton =(ImageButton) findViewById(R.id.playbuttonID);

        pausebutton =(ImageButton) findViewById(R.id.pausebuttonID);

      mediaPlayer = MediaPlayer.create(this,R.raw.alen);
      playbutton.setOnClickListener(this);
      pausebutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

if (v.getId() == R.id.playbuttonID){

     if (mediaPlayer != null){
     mediaPlayer.start();

         Toast.makeText(MainActivity.this,"song start",Toast.LENGTH_SHORT).show();


    }


}
if (v.getId() == R.id.pausebuttonID){

    if (mediaPlayer != null){
        mediaPlayer.pause();

        Toast.makeText(MainActivity.this,"song pause",Toast.LENGTH_SHORT).show();


    }

}

    }
}
