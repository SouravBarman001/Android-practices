package com.example.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MydatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student.db";//database name
    private static final String TABLE_NAME = "student_details";
    private static final String ID = "_id"; // _ means primary key
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String Gender = "Gender";
    private  static  final int VERSION_NUMBER = 3;
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_ALL = " SELECT * FROM "+TABLE_NAME;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+AGE+" INTEGER,"+Gender+" VARCHAR(15));";

    private Context context;
    public MydatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

try{

    // db.execSQL("CREATE TABLE STUDENT (_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR(255),AGE INTEGER);");
    Toast.makeText(context,"onCreate Method is called",Toast.LENGTH_SHORT).show();
    db.execSQL(CREATE_TABLE);
}catch (Exception e){
    Toast.makeText(context,"Exception,"+e,Toast.LENGTH_SHORT).show();

}



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try
        {

            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context,"onUpgrade Method is called",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Exception,"+e,Toast.LENGTH_SHORT).show();
        }



    }

    public Boolean insertuserdata(String name, String Age, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, Age);
        contentValues.put(Gender, dob);
        long result=DB.insert(TABLE_NAME, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor displayalldata(){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery(SELECT_ALL,null);
        return cursor;

    }
    public boolean updateData(String id,String name,String age,String gender){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(Gender, gender);
        DB.update(TABLE_NAME,contentValues,ID+" =? ",new String[]{id});
        return true;
    }

    public int deleteData(String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.delete(TABLE_NAME,ID+" = ? ",new String[]{id});


    }

}
