package com.example.mycountryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class profileActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = findViewById(R.id.profiletextViewid);
        imageView = findViewById(R.id.profileimageViewid);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String CountryName = bundle.getString("name");
            showinfo(CountryName);

        }

    }
    void showinfo(String CountryName){


        if (CountryName.equals("bangladesh")){
            imageView.setImageResource(R.drawable.bangladesh);
            textView.setText(R.string.bangladesh_data);
        }
        if (CountryName.equals("india")){
            imageView.setImageResource(R.drawable.india);
            textView.setText(R.string.india_data);
        }
        if (CountryName.equals("america")){
            imageView.setImageResource(R.drawable.america);
            textView.setText(R.string.india_data);
        }




    }

}
