package xyz.supercoders.basicapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends Activity {

    static int r,g,b;
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        t=(EditText)findViewById(R.id.textView);
    }

    public void rclick(View v){

        r=Integer.parseInt(t.getText().toString());
        t.setText("");
    }
    public void gclick(View v){


        g=Integer.parseInt(t.getText().toString());
        t.setText("");
    }
    public void bclick(View v){

        b=Integer.parseInt(t.getText().toString());
        t.setText("");
        EditText nameColor=(EditText)findViewById(R.id.textView2);
        t.setBackgroundColor(Color.rgb(r,g,b));



    }

}
