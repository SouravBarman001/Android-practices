package com.example.imagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      imgview = (ImageView) findViewById(R.id.ImageviewID);
      imgview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.ImageviewID){
            Toast.makeText(MainActivity.this,"image clicked",Toast.LENGTH_SHORT).show();

        }
    }
}
