package com.example.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   ListView listview;
   TextView textView;
   String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    listview = (ListView) findViewById(R.id.listviewID);
        textView =(TextView) findViewById(R.id.textviewID);

        listItem = getResources().getStringArray(R.array.array_technology);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listItem
    );
    listview.setAdapter(adapter);


   listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           String value = adapter.getItem(position);
           Toast.makeText(getApplicationContext(),value+position, Toast.LENGTH_SHORT).show();
       }
   });



    }
}
