package com.example.admin.testservicediffpackageapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.testserviceapplication.MyPrimeInterface;

public class MainActivity extends AppCompatActivity{

    MyPrimeInterface m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent in=new Intent("com.hello.hi.primeservice");
        bindService(in, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                m=MyPrimeInterface.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        },BIND_AUTO_CREATE);
    }
    public void fun(View v){
        TextView t=(TextView) findViewById(R.id.textView2);
        try {
            t.setText(m.nextPrime()+"");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}