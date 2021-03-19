package com.example.myloginappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signInEmailEditText,signInPasswordEditText;
    private Button SignInButton;
    private TextView signUpTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");

        signInEmailEditText = findViewById(R.id.SignInEditTextEmailid);
        signInPasswordEditText = findViewById(R.id.SignInEditTextPasswordid);
        SignInButton = findViewById(R.id.signInButtonId);
        signUpTextView = findViewById(R.id.signUptextviewid);

        signInEmailEditText.setOnClickListener(this);
        signInPasswordEditText.setOnClickListener(this);
        SignInButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {



        if (v.getId() == R.id.signUptextviewid)
        {
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);


        }






    }
}