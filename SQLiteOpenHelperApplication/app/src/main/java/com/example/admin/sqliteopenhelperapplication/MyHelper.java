package com.example.admin.sqliteopenhelperapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/11/2017.
 */

public class MyHelper extends SQLiteOpenHelper {

    private final static String ID="_ID";
    private final static String USERNAME="username";
    private final static String PASSWORD="password";
    private final static String TABLENAME="usertable";
    private final static String createQuery="create table " +TABLENAME +" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+USERNAME+" TEXT, "+PASSWORD+" TEXT);" ;

    SQLiteDatabase database;
    public MyHelper(Context context,int version) {
        super(context, "MyDatabase", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(createQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table "+TABLENAME);
    onCreate(sqLiteDatabase);
    }
    public boolean insert(String user,String pass){
        ContentValues values=new ContentValues();
        values.put(USERNAME,user);
        values.put(PASSWORD,pass);
        database=getWritableDatabase();
         return database.insert(TABLENAME,null,values)!=-1;

    }
    public Cursor select(String user){
        ArrayList<String> list=new ArrayList<>();
        String query="select "+PASSWORD+" from "+TABLENAME+ " where "+USERNAME+"='"+user+"';";
        database=getReadableDatabase();
        Cursor c=database.rawQuery(query,null);
//        while(c.moveToNext()) {
//            list.add(c.getString(c.getColumnIndex(PASSWORD)));
//        }
        return c;
    }
}
