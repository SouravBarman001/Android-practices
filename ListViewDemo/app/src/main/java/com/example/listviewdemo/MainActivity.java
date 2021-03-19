package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView =(ListView) findViewById(R.id.listViewid);

        String[] countryNames = getResources().getStringArray(R.string.);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.simple_view,R.id.sampleviewid );



    }
}
