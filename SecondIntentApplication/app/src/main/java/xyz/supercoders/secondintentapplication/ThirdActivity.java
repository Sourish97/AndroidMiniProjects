package xyz.supercoders.secondintentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    EditText mn,ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mn=(EditText)findViewById(R.id.editText5);
        ln=(EditText)findViewById(R.id.editText6);
    }
    public void onBackPressed(){

        String m=mn.getText().toString();
        String l=ln.getText().toString();
        Intent in=new Intent(this,SecondActivity.class);
        in.putExtra("middleName",m);
        in.putExtra("lastName",l);
        setResult(106, in);
        finish();
    }
}
