package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup buttongroup;
    private Button button;
    private TextView textView;
    private RadioButton genderbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttongroup =(RadioGroup) findViewById(R.id.radiogroupID);
        button =(Button) findViewById(R.id.buttonperformID);
        textView = (TextView)findViewById(R.id.texyshowID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                   int selectedID =  buttongroup.getCheckedRadioButtonId();
                    genderbutton = (RadioButton) findViewById(selectedID);

                    textView.setText("you select "+genderbutton.getText().toString());

                    //We have to need exception handling
            }
        });
    }
}
