package com.example.kushal.contentprov;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//sharedpref
public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       username=(EditText)findViewById(R.id.editText);
         pass=(EditText)findViewById(R.id.editText3);
    }

    public void newUser(View v)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("userinfo",MODE_PRIVATE);
       SharedPreferences.Editor edit= sharedPreferences.edit();
        edit.putString("username",username.getText().toString());
        edit.putString("pass",pass.getText().toString());
        edit.commit();
        Toast.makeText(this, "REGISTERED SUCCESSFULL", Toast.LENGTH_LONG).show();
    }
    public void login(View v)
    {
        SharedPreferences sh=getSharedPreferences("userinfo",MODE_PRIVATE);
        String user=sh.getString("username","");
        String password=sh.getString("pass","");
        if(user.equals(username.getText().toString()))
        {
            if(password.equals(pass.getText().toString()))
                Toast.makeText(this, "LOGIN SUCCESSFULL", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "PASSWORD INCORRECT", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "USERNAME DOESNT EXIST", Toast.LENGTH_LONG).show();

    }
}
