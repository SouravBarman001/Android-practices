package com.example.sharepreferanceexample1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView detailstextview;
    private EditText username,password;
    private Button save,load;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailstextview =(TextView) findViewById(R.id.detailstextviewid);
        username = (EditText) findViewById(R.id.UsernameEdittextid);
        password = (EditText) findViewById(R.id.UserPasswordid);
        save = (Button) findViewById(R.id.savebuttonid);
        load =(Button) findViewById(R.id.loadbuttonid);


        save.setOnClickListener(this);
       load.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.savebuttonid){

            String Username = username.getText().toString();
            String Userpassword = password.getText().toString();

            if (username.equals("") && password.equals("")){
                Toast.makeText(getApplicationContext(),"Please Enter Some Data",Toast.LENGTH_SHORT).show();
            }
            else
            {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey",Username);
                editor.putString("userpasswordkey",Userpassword);
                editor.commit();
              //  username.setText("");
              //  password.setText("");
                Toast.makeText(getApplicationContext(),"Data has been stored successfully",Toast.LENGTH_SHORT).show();

            }





        }
        else if (v.getId()==R.id.loadbuttonid){
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
           if (sharedPreferences.contains("usernameKey") && sharedPreferences.contains("userpasswordkey")){
               String username = sharedPreferences.getString("usernameKey","Data does not found");
               String password = sharedPreferences.getString("userpasswordkey","Data does not found");

               detailstextview.setText(username+"\n"+password);

           }

        }



    }
}