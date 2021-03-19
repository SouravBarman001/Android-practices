package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox applebox,mangobox,orangebox;
    private Button buttonclick;
    private TextView ResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                applebox=   (CheckBox)    findViewById(R.id.appleboxID);
                mangobox=   (CheckBox)     findViewById(R.id.mangoboxID);
                orangebox=  (CheckBox)     findViewById(R.id.orangeboxID);
                buttonclick=  (Button)  findViewById(R.id.buttoncheckID);
                ResultView=  (TextView)   findViewById(R.id.txtviewID);



        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringBuilder stringbuilder = new StringBuilder();


             try {

                 int totalcost = 0;
                 if (applebox.isChecked()){
                     String item =applebox.getText().toString();
                     stringbuilder.append(item +"50TK"+"\n");
                     totalcost= totalcost+50;
                 }
                 if (orangebox.isChecked()){
                     String item = orangebox.getText().toString();
                     stringbuilder.append(item+"40TK"+"\n");
                     totalcost= totalcost+40;

                 }
                 if (mangobox.isChecked()){

                     String item =mangobox.getText().toString();
                     stringbuilder.append(item +"55TK"+"\n");
                     totalcost= totalcost+55;
                 }
                 ResultView.setText(stringbuilder);
                 ResultView.setText("Total Cost:"+totalcost);

             }catch (Exception e){
                 ResultView.setText("Selected items:"+"\n");
                 ResultView.setText("Select items:0");
                 ResultView.setText("Total Cost:0");
             }


            }
        });


            }
}
