package xyz.supercoders.firstintentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        t=(EditText)findViewById(R.id.textView);
    }
    public void Click(View v){
    String s=t.getText().toString();
    Intent in=new Intent("com.hello.hi.sourish");
        in.putExtra("name", s);
    startActivityForResult(in,101);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent in){
String s=in.getStringExtra("msg");
        t.setText(s);
    }
}
