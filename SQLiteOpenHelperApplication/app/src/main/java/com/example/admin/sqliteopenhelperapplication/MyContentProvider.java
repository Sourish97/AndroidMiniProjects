package com.example.admin.sqliteopenhelperapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.List;

public class MyContentProvider extends ContentProvider {
    MyHelper myhelper;
    public final static Uri CONTENT_URI=Uri.parse("content://com.example.admin.sqliteopenhelperapplication.MyDatabase");
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        boolean result=myhelper.insert(values.get("username").toString(),values.get("password").toString());
        if(result)
        Toast.makeText(getContext(), "REGISTERED SUCCESSFULL", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getContext(), "UNSUCCESSFULL", Toast.LENGTH_LONG).show();
        return uri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        myhelper=new MyHelper(getContext(),1);
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        String user=projection[0];
        Cursor c=myhelper.select(user);
        return c;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
