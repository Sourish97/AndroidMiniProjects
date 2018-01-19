package xyz.supercoders.firstintentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in=this.getIntent();
        setContentView(R.layout.activity_second);
        t=(EditText)findViewById(R.id.textView2);
        String v=in.getStringExtra("name");
        t.setText(v);
    }
    @Override
    public void onBackPressed(){

        String n=t.getText().toString();
        Intent in=new Intent(this,FirstActivity.class);
        in.putExtra("msg",n);
        setResult(105,in);
        finish();
    }
}
