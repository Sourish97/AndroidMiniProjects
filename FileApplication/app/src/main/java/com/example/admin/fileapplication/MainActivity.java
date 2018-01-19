package com.example.admin.fileapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    Button b;
    ProgressBar p;
    File pictureFile,imageFile;
    ArrayList<String> imageUri;
    ArrayList<String> imagePath;
    File[] a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        p=findViewById(R.id.progressBar);
        imageUri=new ArrayList<>();
        imagePath=new ArrayList<>();
        pictureFile=new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM))+"/Camera");
        // /storage/emulated/0/DCIM/Camera
        if(pictureFile.exists()){
            Toast.makeText(this,"Pictures File exists",Toast.LENGTH_LONG).show();
            Log.d("Picture File Path",pictureFile.getAbsolutePath());
            a=pictureFile.listFiles();
            //String[] s=pictureFile.list();

        }
        else
            Toast.makeText(this,"Pictures File does not exist",Toast.LENGTH_LONG).show();


    }
    class MyTask extends AsyncTask<Void,Integer,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            int j=0;
            for(int i=1;i<=100;i++){
                j=i;
                imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/Camera",a[i-1].getName());
                imageUri.add(Uri.fromFile(imageFile).toString());
                // file:///storage/emulated/0/Pictures/Camera/IMG_20150525_155612.jpg
                // file:///storage/emulated/0/Pictures/Camera/20130830_214051.jpg
                imagePath.add(a[i-1].getAbsolutePath());
                Log.d("Image Uri",Uri.fromFile(imageFile).toString());
                if(i%10==0)
                    publishProgress(i);
            }
            return j;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            p.setProgress(integer);
            Intent in=new Intent(MainActivity.this,Main2Activity.class);
            in.putStringArrayListExtra("imageUri",imageUri);
            in.putStringArrayListExtra("imagePath",imagePath);
            startActivity(in);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            p.setProgress(values[0]);
        }
    }
    public void click(View v){
//        try {
//            FileOutputStream fs=openFileOutput("abc.txt",MODE_PRIVATE);
//            fs.write("hello to all".getBytes());
//            fs.close();
//            File file=getFilesDir();
//            String name="";
//            File[] a=file.listFiles();
//            for(int i=0;i<a.length;i++){
//                Log.i("Files",a[i].getAbsolutePath());
//            }
//
//            File file=getExternalFilesDir(null);
//            b.setText(file.getAbsolutePath());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        new MyTask().execute();
    }
}
