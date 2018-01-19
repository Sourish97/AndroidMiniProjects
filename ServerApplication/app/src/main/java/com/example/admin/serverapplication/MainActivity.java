package com.example.admin.serverapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText t;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(EditText)findViewById(R.id.editText);
        send=(Button)findViewById(R.id.button);
    }
    public void onClick(View v){
        Log.i("onCLick","Button Pressed");
         String name=t.getText().toString();
//        try {
//            URL url=new URL("http://192.168.1.118:8080/testservlet/TestServlet");
//            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setDoOutput(true);
//            PrintWriter pw=new PrintWriter(urlConnection.getOutputStream());
//            String s= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
//            pw.write(s);
//            pw.flush();
//            pw.close();
//            String response=urlConnection.getResponseCode()+"";
//            Toast.makeText(this,response,Toast.LENGTH_LONG).show();
//            urlConnection.disconnect();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            URL url = new URL("http://192.168.1.118:8080/testservlet/TestServlet");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("username", name);
            String query = builder.build().getEncodedQuery();
            Log.i("Query",query);
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            urlConnection.connect();
            Log.i("onClick", urlConnection.getResponseMessage());
            Log.i("onClick", urlConnection.getRequestMethod());
            Log.i("onClick", String.valueOf(urlConnection.getResponseCode()));

        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
    }
}
