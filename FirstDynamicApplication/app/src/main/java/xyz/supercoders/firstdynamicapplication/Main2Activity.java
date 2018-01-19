package xyz.supercoders.firstdynamicapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText[] a;
    int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in=getIntent();
        final int n=Integer.parseInt(in.getStringExtra("total"));
        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        LinearLayout layout=(LinearLayout)inflater.inflate(R.layout.new_layout, null);
        a=new EditText[n];

        for(int i=0;i<n;i++){
            EditText t;
            if(i==0)
            t=(EditText)layout.findViewById(R.id.editText2);
            else {
                t = new EditText(this);
                t.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(t);
            }
            a[i] = t;
        }
        final TextView t=new TextView(this);
        t.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(t);
        t.setText("This is TextView");
        Button b=(Button)layout.findViewById(R.id.button2);
        b.setText("Add");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < n; i++) {
                    sum += Integer.parseInt(a[i].getText().toString());
                }
                t.setText("" + sum);

            }
        });

        setContentView(layout);
    }

}

