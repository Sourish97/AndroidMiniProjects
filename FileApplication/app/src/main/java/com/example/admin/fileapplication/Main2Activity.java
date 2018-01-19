package com.example.admin.fileapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    File imageFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView list=(ListView)findViewById(R.id.listview);
        Intent in=getIntent();
        ArrayList<String> imageUri=in.getStringArrayListExtra("imageUri");
        ArrayList<String> imagePath=in.getStringArrayListExtra("imagePath");
        Toast.makeText(this,"imageUri Length:"+imageUri.size(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,"imagePath Length:"+imagePath.size(),Toast.LENGTH_LONG).show();
        Log.d("Activity2 Image Uri:",imageUri.get(0).toString());
        Log.d("Activity2 Image Path:",imagePath.get(0).toString());

        MyArrayAdapter<String> adapter=new MyArrayAdapter<String>(this,R.layout.new_layout,imageUri,imagePath);
        list.setAdapter(adapter);
    }
    class MyArrayAdapter<String> extends ArrayAdapter<String> {
        int rid;
        ArrayList<String> uri;
        ArrayList<String> imagepath;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View vg=inflater.inflate(rid, null);
            ImageView img=(ImageView) vg.findViewById(R.id.imageView);
            TextView path=(TextView)  vg.findViewById(R.id.textView);
            img.setImageURI(Uri.parse(uri.get(position).toString()));
            //img.setImageURI(Uri.parse("file:///storage/emulated/0/DCIM/Camera/IMG_20150525_155612.jpg"));
            path.setText(imagepath.get(position).toString());
            Log.d("Activity2 Image Uri:",Uri.parse(uri.get(position).toString()).toString());

            return vg;
        }

        MyArrayAdapter(Context context,int rid,ArrayList<String> u,ArrayList<String> p){
            super(context,rid,u);
            Toast.makeText(Main2Activity.this,"Constructor called",Toast.LENGTH_LONG).show();
            this.rid=rid;
            uri=u;
            imagepath=p;
        }
    }
}
