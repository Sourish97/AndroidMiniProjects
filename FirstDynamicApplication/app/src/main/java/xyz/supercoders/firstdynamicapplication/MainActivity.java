package xyz.supercoders.firstdynamicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v){
        Intent in=new Intent(this,Main2Activity.class);
        EditText t=(EditText) findViewById(R.id.editText);
        String no=t.getText().toString();
        in.putExtra("total",no);
        startActivity(in);
    }
}
