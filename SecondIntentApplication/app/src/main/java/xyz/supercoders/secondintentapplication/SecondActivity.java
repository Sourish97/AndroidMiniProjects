package xyz.supercoders.secondintentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText firstName;
    String mn,ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in=this.getIntent();
        setContentView(R.layout.activity_second);
        firstName=(EditText)findViewById(R.id.editText4);
    }
    public void Click(View v){
        Intent in=new Intent("com.sourish.third");
        startActivityForResult(in,102);
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent in){
        mn=in.getStringExtra("middleName");
        ln=in.getStringExtra("lastName");
        if(mn.equals("")){
            Toast t=Toast.makeText(this,"Middle Name is Empty",Toast.LENGTH_LONG);
            t.show();
        }
        if(ln.equals("")){

          Toast t2=Toast.makeText(this,"Last Name is Empty",Toast.LENGTH_LONG);
           t2.show();
        }
    }
    @Override
    public void onBackPressed(){

        String fn=firstName.getText().toString();
        Intent in=new Intent(this,FirstActivity.class);
        in.putExtra("firstName",fn);
        in.putExtra("middleName",mn);
        in.putExtra("lastName",ln);
        setResult(105,in);
        finish();
    }
}
