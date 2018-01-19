package com.kossine.newapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    SeekBar s1,s2,s3;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=findViewById(R.id.lay);
        s1=(SeekBar)findViewById(R.id.seekBar);
        s2=(SeekBar)findViewById(R.id.seekBar2);
        s3=(SeekBar)findViewById(R.id.seekBar3);
        s1.setOnSeekBarChangeListener(this);
        s2.setOnSeekBarChangeListener(this);
        s3.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        view.setBackgroundColor(Color.rgb(s1.getProgress(),s2.getProgress(),s3.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
