package com.example.admin.sqliteopenhelperapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText pass;
    MyHelper myhelper;
    private final static String ID="_ID";
    private final static String USERNAME="username";
    private final static String PASSWORD="password";
    private final static String TABLENAME="usertable";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        myhelper=new MyHelper(this,1);
    }
    public void newUser(View v)
    {
        //SharedPreferences sharedPreferences=getSharedPreferences("userinfo",MODE_PRIVATE);
        //SharedPreferences.Editor edit= sharedPreferences.edit();
        //edit.putString("username",username.getText().toString());
        //edit.putString("pass",pass.getText().toString());
        //edit.commit();
        String user =username.getText().toString();
        String password=pass.getText().toString();
//        if(myhelper.insert(user,password))
//        Toast.makeText(this, "REGISTERED SUCCESSFULL", Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(this, "UNSUCCESSFULL", Toast.LENGTH_LONG).show();
        ContentValues values=new ContentValues();
        values.put(USERNAME,user);
        values.put(PASSWORD,password);
        getContentResolver().insert(MyContentProvider.CONTENT_URI,values);
    }
        public void login(View v)
    {
        boolean flag=false;
        //SharedPreferences sh=getSharedPreferences("userinfo",MODE_PRIVATE);
        String user=username.getText().toString();
        String password=pass.getText().toString();
//        List<String> list=myhelper.select(user);
        Bundle b=new Bundle();
        b.putString("username",user);
        String[] projection={user};
        Cursor c=getContentResolver().query(MyContentProvider.CONTENT_URI,projection,null,null,null);
        List<String> list=new ArrayList<String>();
        while(c.moveToNext()) {
            list.add(c.getString(c.getColumnIndex(PASSWORD)));
        }
        for(int i=0;i<list.size();i++){
            if(password.equals(list.get(i)))
                flag=true;
        }
            if(flag)
            {
                Toast.makeText(this, "LOGIN SUCCESSFULL", Toast.LENGTH_LONG).show();
                flag=false;
            }
        else
            Toast.makeText(this, "PASSWORD INCORRECT /USERNAME DOESNT EXIST", Toast.LENGTH_LONG).show();
    }




    @Override
    public void onDestroy()
    {
        super.onDestroy();

    }

}
