package xyz.supercoders.secondintentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText fn,mn,ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        fn=(EditText)findViewById(R.id.editText);
        mn=(EditText)findViewById(R.id.editText2);
        ln=(EditText)findViewById(R.id.editText3);
    }
    public void Click(View v){
        Intent in=new Intent("com.sourish.second");
        startActivityForResult(in, 101);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent in){
        String firstName=in.getStringExtra("firstName");
        String middleName=in.getStringExtra("middleName");
        String lastName=in.getStringExtra("lastName");
        fn.setText(firstName);
        mn.setText(middleName);
        ln.setText(lastName);
    }
}
