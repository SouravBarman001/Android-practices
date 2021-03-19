package com.example.mylogindemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userDetails.db";
    private static final String TABLE_NAME = "UserInfo";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USER_NAME = "Username";
    private static final String PASSWORD = "Password";
    private  static final int VERSION_NUMBER = 3;
    private Context context;

   private static final  String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+ "(" +ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +NAME+ " VARCHAR(255) NOT NULL," +EMAIL+ " TEXT NOT NULL," +USER_NAME+ " TEXT NOT NULL," +PASSWORD+ " TEXT NOT NULL);";
   private static final String DROP_TABLE = " DROP TABLE IF EXISTS "+ TABLE_NAME;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

try{

    db.execSQL(CREATE_TABLE);
    Toast.makeText(context,"Table create",Toast.LENGTH_SHORT).show();



}catch (Exception e){
    Toast.makeText(context,"Table fail to create"+e,Toast.LENGTH_SHORT).show();
}


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context,"onUpgrade method called",Toast.LENGTH_SHORT).show();

            db.execSQL(DROP_TABLE);
            onCreate(db);



        }catch (Exception e){
            Toast.makeText(context,"fail to onUpgrade"+e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(Userdetails userdetails){

SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,userdetails.getName());
        contentValues.put(EMAIL,userdetails.getEmail());
        contentValues.put(USER_NAME,userdetails.getUsername());
        contentValues.put(PASSWORD,userdetails.getPassword());

       long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
       return  rowId;

    }

    public boolean findpassword(String uname,String pass)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result = false;

        if (cursor.getCount()==0){
            Toast.makeText(context,"No data found",Toast.LENGTH_SHORT).show();

        }else
        {

            while (cursor.moveToNext()){
                String username = cursor.getString(3);
                String password = cursor.getString(4);

                if (username.equals(uname) && password.equals(pass)){
                    result = true;
                    break;

                }


            }



        }

      return result;

    }


}
