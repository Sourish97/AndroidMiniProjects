package com.example.admin.threadapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button2);
    }
    boolean flag=true;
    int i=0;
    class MyTask extends AsyncTask<String,Integer,Integer> {

        @Override
        protected void onPreExecute() {
            i=0;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            while(flag){
                i++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i%10==0)
                    publishProgress(i);
            }
            for(String s:strings)
                Log.i("params",s);
            return i;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            b.setText(values[0]+"");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            b.setText(integer+"");
        }
    }
    public void press(View v){
            new MyTask().execute("hello","hi","bye");
        }

    public void ok(View v){
        flag=false;
        ((Button)v).setText(i+"");
    }
}
