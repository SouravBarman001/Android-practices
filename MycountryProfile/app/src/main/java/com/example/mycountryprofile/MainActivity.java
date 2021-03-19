package com.example.mycountryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.buttonbangladeshid);
        b2 = findViewById(R.id.buttonindiaid);
        b3 = findViewById(R.id.buttonamericaid);

         b1.setOnClickListener(this);
         b2.setOnClickListener(this);
         b3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonbangladeshid){
            Intent intent = new Intent(MainActivity.this,profileActivity.class);
             intent.putExtra("name","bangladesh");
            startActivity(intent);
        }if (v.getId()==R.id.buttonindiaid){
            Intent intent = new Intent(MainActivity.this,profileActivity.class);
            intent.putExtra("name","india");
            startActivity(intent);
        }if (v.getId()==R.id.buttonamericaid){
            Intent intent = new Intent(MainActivity.this,profileActivity.class);
            intent.putExtra("name","america");
            startActivity(intent);
        }


    }
}
