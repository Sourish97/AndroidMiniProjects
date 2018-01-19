package com.example.admin.mlfqapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText p,b;
    ListView RR1,RR2,FCFS;
    ArrayAdapter<String> adapter1,adapter2,adapter3;
    ArrayList<String> RR1List,RR2List,FCFSList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p=(EditText) findViewById(R.id.editText);        setContentView(R.layout.activity_main);

        b=(EditText) findViewById(R.id.editText2);
        RR1=(ListView)findViewById(R.id.listView1);
        RR2=(ListView)findViewById(R.id.listView2);
        FCFS=(ListView)findViewById(R.id.listView3);
        RR1List = new ArrayList<String>();
        RR2List = new ArrayList<String>();
        FCFSList = new ArrayList<String>();
        adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, RR1List){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                return textView;

            }
        };
        adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, RR2List){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                return textView;
            }
        };
        adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, FCFSList){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                return textView;
            }
        };
        RR1.setAdapter(adapter1);
        RR2.setAdapter(adapter2);
        FCFS.setAdapter(adapter3);
    }
    public void onClick(View v){

        String process=p.getText().toString();
        int burstTime=Integer.parseInt(b.getText().toString());
        if(burstTime<=8){
            RR1List.add(process+"   "+burstTime+"ms");
            adapter1.notifyDataSetChanged();
        }
        else if(burstTime>8 && burstTime<=24){
            RR1List.add(process+"   "+8+"ms");
            burstTime-=8;
            RR2List.add(process+"   "+burstTime+"ms");
            adapter1.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
        }
        else{
            RR1List.add(process+"   "+8+"ms");
            burstTime-=8;
            RR2List.add(process+"   "+16+"ms");
            if(burstTime>=16)
            burstTime-=16;
            FCFSList.add(process+"   "+burstTime+"ms");
            adapter1.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
            adapter3.notifyDataSetChanged();
        }

    }
}
