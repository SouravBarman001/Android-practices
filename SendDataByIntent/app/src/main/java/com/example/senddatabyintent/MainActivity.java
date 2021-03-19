package com.example.senddatabyintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    button = (Button)findViewById(R.id.buttonid);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =  new Intent(MainActivity.this,ReceiveDataIntent.class);
            intent.putExtra("tag","I live in joypurhat");
            startActivity(intent);


        }
    });

    }
}
