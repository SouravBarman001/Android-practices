package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultview;
    private EditText editText;
    private Button checkbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultview=(TextView)findViewById(R.id.resulttextviewid);
        editText=(EditText)findViewById(R.id.edittextid);
        checkbutton= (Button)findViewById(R.id.buttonid);
        checkbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       String guessString = editText.getText().toString();
if (guessString.isEmpty()){
showerror();
}
      else{

    int guess = Integer.parseInt(guessString);
if (guess>5){
    showerror();
}else
{
    //generating random number

    Random random = new Random();

    int randomNumber = random.nextInt(5)+1;
    if (randomNumber == guess){

        resultview.setText("Congratultion you have won");
    }
    else{
        resultview.setText("Sorry!you have lost.Random number is "+randomNumber);
    }
}


}


    }

    public void showerror(){
        editText.setError("Please enter a valid input");
        editText.requestFocus();
      return ;
    }
}
