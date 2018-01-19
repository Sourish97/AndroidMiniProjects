package com.facebook.cameraapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imgview;
    File imageFile;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgview=(ImageView) findViewById(R.id.imageView);
        imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
        imageUri =Uri.fromFile(imageFile);
    }
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public void onClick(View v){
        Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        in.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        in.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(in, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            switch (resultCode){
                case Activity.RESULT_OK:
                    if(imageFile.exists()){
                        imgview.setImageURI(imageUri);
                        Toast.makeText(this,"Image set",Toast.LENGTH_LONG);

                    }
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(this,"Result Cancelled",Toast.LENGTH_LONG);
            }

        }

    }

}
