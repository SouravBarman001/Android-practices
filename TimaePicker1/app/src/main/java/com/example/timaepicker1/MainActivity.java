package com.example.timaepicker1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TimePickerDialog timePickerDialog;
    private Button button;
    private TextView textView;

 //ERROR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button =(Button) findViewById(R.id.Buttonid);
         textView= (TextView) findViewById(R.id.textViewwid);


        button.setOnClickListener(new View.OnClickListener() {
            TimePickerDialog time = new TimePickerDialog(this);
            int currentHour = time.getCurrentFocus()
            int currentMinute = time.

            @Override
            public void onClick(View v) {

                timePickerDialog = new TimePickerDialog(MainActivity.this,

                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            }
                        },currentHour,currentMinute,true);

            }
        });


    }
}
