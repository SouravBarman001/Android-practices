package com.example.exampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

ButtonClicked = (Button) findViewById(R.id.button_ID);

ButtonClicked.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        LayoutInflater inflater = getLayoutInflater();
         inflater.inflate(R.layout.@)
    }
});

    }
}
