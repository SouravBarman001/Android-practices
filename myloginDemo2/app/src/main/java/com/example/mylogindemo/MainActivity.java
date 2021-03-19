package com.example.mylogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button SignInbutton,SignUpHerebutton;
    private EditText usernameloginEditText;
    private EditText passwordloginEditText;


    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  DB.getWritableDatabase();

        usernameloginEditText = findViewById(R.id.usernameloginid);
        passwordloginEditText = findViewById(R.id.Passwordloginid);

        SignInbutton = findViewById(R.id.SignInbuttonid);
        SignUpHerebutton = findViewById(R.id.SignUpherebuttonid);

       SignInbutton.setOnClickListener(this);
        SignUpHerebutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

       String username = usernameloginEditText.getText().toString();
       String password = passwordloginEditText.getText().toString();

        if (v.getId()==R.id.SignInbuttonid)
        {
            Boolean result = DB.findpassword(username,password);

if (result == true)
{

       Intent intent = new Intent(MainActivity.this,MainActivity2.class);
       startActivity(intent);

}else {

    Toast.makeText(getApplicationContext(),"Username and Password did not match",Toast.LENGTH_SHORT).show();
}




        }

        else if (v.getId()==R.id.SignUpherebuttonid)
        {
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);

        }


    }
}