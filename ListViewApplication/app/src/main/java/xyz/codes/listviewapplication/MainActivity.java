package xyz.codes.listviewapplication;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list=(ListView)findViewById(R.id.listView);
        String array[]={"Apple","Banana","Orange"};
        String price[]={"10","20","30"};
        int image[]={R.drawable.apple,R.drawable.banana,R.drawable.orange};
        int flag[]={0,0,0};
        MyArrayAdapter<String> adapter=new MyArrayAdapter<String>(this,R.layout.price_list,array,price,image,flag);
        list.setAdapter(adapter);
    }
    class MyArrayAdapter<String> extends ArrayAdapter<String>{
        int rid;
        String array[];
        String price[];
        int image[];
        int flag[];
        int total=0;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View vg=inflater.inflate(rid, null);
            TextView name=(TextView)vg.findViewById(R.id.textView);
            name.setText(array[position] + "");
            final TextView pricetext=(TextView)vg.findViewById(R.id.textView2);
            pricetext.setText(price[position] + "");
            ImageView img=(ImageView)vg.findViewById(R.id.imageView);

            img.setImageResource(image[position]);
            vg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag[position] == 0) {
                        total += Integer.parseInt(pricetext.getText().toString());
                        flag[position] = 1;
                        v.setBackgroundColor(Color.BLUE);
                    } else {
                        total -= Integer.parseInt(pricetext.getText().toString());
                        flag[position] = 0;
                        v.setBackgroundColor(Color.WHITE);
                    }
                    Toast.makeText(MainActivity.this, "Your Total is " + total, Toast.LENGTH_LONG).show();
                }
            });

            return vg;
        }

        MyArrayAdapter(Context context,int rid,String[] a,String[] p,int[] i,int f[]){
            super(context,rid,a);
            this.rid=rid;
            array=a;
            price=p;
            image=i;
            flag=f;
        }
    }
}
