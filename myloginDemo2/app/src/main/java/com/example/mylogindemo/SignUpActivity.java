package com.example.mylogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,usernameEditText,passwordEditText,emailEditText;
    private Button signUpButton,backbutton;


  DatabaseHelper db;
    Userdetails userdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = findViewById(R.id.namesignupid);
        usernameEditText = findViewById(R.id.usernmesignupid);
        passwordEditText = findViewById(R.id.passwordsignupid);
        emailEditText = findViewById(R.id.emailsignupid);
        signUpButton = findViewById(R.id.signupuserdetailsid);
        backbutton = findViewById(R.id.backbuttonid);

       signUpButton.setOnClickListener(this);
       backbutton.setOnClickListener(this);
  db = new DatabaseHelper(this);


         userdetails = new Userdetails();

    }

    @Override
    public void onClick(View v) {

String name = nameEditText.getText().toString();
String username = usernameEditText.getText().toString();
String email = emailEditText.getText().toString();
String password = passwordEditText.getText().toString();

 userdetails.setName(name);
 userdetails.setEmail(email);
 userdetails.setPassword(password);
 userdetails.setUsername(username);

   long rowId = db.insertData(userdetails);

if (rowId>0){
    Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_LONG).show();
}
else{
    Toast.makeText(getApplicationContext(),"Failed to SignUp",Toast.LENGTH_LONG).show();
}


    }
}