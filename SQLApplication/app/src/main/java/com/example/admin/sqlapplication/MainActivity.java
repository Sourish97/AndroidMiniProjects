package com.example.admin.sqlapplication;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void press(View v){
        String colNames[]={ContactsContract.CommonDataKinds.Email.ADDRESS};
        Cursor c=getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,colNames,null,null,null);
        while(c.moveToNext()){
            Log.i("Mail",c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS)));
        }
    }
}
