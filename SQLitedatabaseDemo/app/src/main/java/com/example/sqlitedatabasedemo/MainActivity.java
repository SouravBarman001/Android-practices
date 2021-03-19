package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MydatabaseHelper mydatabaseHelper;

    private EditText NameEditText,AgeEditText,GenderEditText,idEditText;
    private Button button,Displaydatabutton,updatedatabutton,deletebutton;
    MydatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                mydatabaseHelper = new MydatabaseHelper(this);
                SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

                NameEditText = findViewById(R.id.EditNameTextID);
                AgeEditText  =findViewById(R.id.EditAgeTextID);
                GenderEditText = findViewById(R.id.EditGenderTextID);
                button = findViewById(R.id.AddButtonID);
                Displaydatabutton = findViewById(R.id.displayalldataButtonID);
                updatedatabutton = findViewById(R.id.updatedataButtonID);
                idEditText = findViewById(R.id.IdeditTextID);
                deletebutton = findViewById(R.id.deleteButtonID);
                DB = new MydatabaseHelper(this);

                button.setOnClickListener(this);
                Displaydatabutton.setOnClickListener(this);
                updatedatabutton.setOnClickListener(this);
                deletebutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String Name = NameEditText.getText().toString().trim();
        String Age = AgeEditText.getText().toString().trim();
        String Gender = GenderEditText.getText().toString().trim();
        String Id = idEditText.getText().toString().trim();

        if (v.getId()==R.id.AddButtonID)
        {

            Boolean checkinsertdata = DB.insertuserdata(Name, Age, Gender);
            if(checkinsertdata==true){
                Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            }

            else{
                Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

            }
        }

        else if(v.getId()==R.id.displayalldataButtonID){

            Cursor cursor = DB.displayalldata();

            if (cursor.getCount()==0){
                // There is no data
                showData("Error","There is no message");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()){

                 stringBuffer.append("ID: "+cursor.getString(0)+"\n");
                stringBuffer.append("Name: "+cursor.getString(1)+"\n");
                stringBuffer.append("Age: "+cursor.getString(2)+"\n");
                stringBuffer.append("Gender: "+cursor.getString(3)+"\n\n");

            }

           showData("ResultSet",stringBuffer.toString());
        }

        else if(v.getId() == R.id.updatedataButtonID){

         boolean isUpdated = DB.updateData(Id,Name,Age,Gender);

         if (isUpdated == true){
             Toast.makeText(MainActivity.this,"Successfully Updated",Toast.LENGTH_SHORT).show();
         }else {
             Toast.makeText(MainActivity.this,"Failed to Update",Toast.LENGTH_SHORT).show();
         }


        }

        else if (v.getId()== R.id.deleteButtonID)
        {
              int data = DB.deleteData(Id);
              if (data>0){
                  Toast.makeText(MainActivity.this,"Successfully Deleted",Toast.LENGTH_SHORT).show();
              }
              else{
                  Toast.makeText(MainActivity.this,"Failed to Delete",Toast.LENGTH_SHORT).show();
              }


        }



    }

    private void showData(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();

    }
}