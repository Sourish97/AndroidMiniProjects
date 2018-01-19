package com.example.kushal.database;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kushal.database.R;

import static android.R.attr.password;


public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    private final static String ID="_ID";
    private final static String USERNAME="username";
    private final static String PASSWORD="password";
    private final static String TABLENAME="usertable";
    private final static String createQuery="create table " +TABLENAME +"("+ID+" INTEGER AUTOINCREMENT,"+USERNAME+" TEXT,"+PASSWORD+" ,TEXT);" ;

    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        try {
            database = openOrCreateDatabase("dbase", MODE_PRIVATE, null);
        }
        catch(Exception e)
        {
            Log.i("ERROR" ,"WHILE OPENING");
        }
        try {
            database.execSQL(createQuery);
        }
        catch (Exception e)
        {
            Log.i("error","while creating table");
        }

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
        String query="insert into "+TABLENAME+ "values('"+user+"','"+password+"');";
        Toast.makeText(this, "REGISTERED SUCCESSFULL", Toast.LENGTH_LONG).show();
    }
    public void login(View v)
    {
        boolean flag=true;
        //SharedPreferences sh=getSharedPreferences("userinfo",MODE_PRIVATE);
        String user=username.getText().toString();
        String query="select  * from "+TABLENAME+ " where "+USERNAME+"='"+user+"';";
            Cursor c=database.rawQuery(query,null);
        while(c.moveToNext())
        {
            String pass1=c.getString(c.getColumnIndex(PASSWORD));
            if(pass1.equals(pass.getText().toString()))
            {
                Toast.makeText(this, "LOGIN SUCCESSFULL", Toast.LENGTH_LONG).show();
            flag=false;}

        }

        if(flag)
            Toast.makeText(this, "USERNAME DOESNT EXIST", Toast.LENGTH_LONG).show();
    }




    @Override
    public void onDestroy()
    {
        super.onDestroy();
        try{
            database.close();
        }
        catch(Exception e)
        {
            Log.i("error","while closing");
        }
    }
}
