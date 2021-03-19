package com.example.senddatabyintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReceiveDataIntent extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data_intent);

        textView = (TextView) findViewById(R.id.textViewid);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
           String value = bundle.getString("tag");
            textView.setText(value);
        }

    }
}
