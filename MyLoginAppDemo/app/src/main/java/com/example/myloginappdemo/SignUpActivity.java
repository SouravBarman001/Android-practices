package com.example.myloginappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpEmailEditText,signUpPasswordEditText;
    private Button SignUpButton;
    private TextView signInTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");
        signUpEmailEditText = findViewById(R.id.SignUpEditTextEmailid);
        signUpPasswordEditText = findViewById(R.id.SignUpEditTextPasswordid);
        SignUpButton = findViewById(R.id.SignUpButtonId);
        signInTextView = findViewById(R.id.SignIntextviewid);

        signUpEmailEditText.setOnClickListener(this);
        signUpPasswordEditText.setOnClickListener(this);
        SignUpButton.setOnClickListener(this);
        signInTextView.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.SignIntextviewid){
            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
            startActivity(intent);

        }

        else if (v.getId() == R.id.SignUpButtonId){
            UserRegister();

        }

    }

    private void UserRegister() {

   String email = signUpEmailEditText.getText().toString().trim();
   String password = signUpPasswordEditText.getText().toString().trim();

     if (email.isEmpty())
     {

         signUpEmailEditText.setError("Enter an email address");
         signUpEmailEditText.requestFocus();
         return;


     }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {

            signUpEmailEditText.setError("Enter an valid email address");
            signUpEmailEditText.requestFocus();
            return;


        }
        if (password.isEmpty()){
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;

        }

        if (password.length()<6){
            signUpPasswordEditText.setError("Minimum length of a password is 6");
            signUpPasswordEditText.requestFocus();
            return;

        }
    }
}