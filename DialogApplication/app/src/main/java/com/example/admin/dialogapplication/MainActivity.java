package com.example.admin.dialogapplication;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name,age;
    int day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText);
        age=(EditText)findViewById(R.id.editText2);
        age.setOnClickListener(this);
    }
    public void press(View v){
        String n=name.getText().toString();
        String a=age.getText().toString();
        int ag= Calendar.getInstance().get(Calendar.YEAR);
        ag=ag-year;
        String mssg="Your name is "+n+" and age is "+ag;
        new AlertDialog.Builder(this).setMessage(mssg).create().show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                year=i;
                month=i1;
                day=i2;
                age.setText(i2+"/"+(i1+1)+"/"+i);
            }
        },2000,0,1);
        dialog.show();
    }

}
