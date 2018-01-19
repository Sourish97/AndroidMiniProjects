package com.example.admin.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    int n=2;
    boolean prime(int n){
        for(int i=2;i<Math.sqrt(n);i++)
            if(n%i==0)
                return false;
        return true;
    }
    int nextPrime(){
        while(prime(n)){
            n++;
        }
        return n;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this,"Next Prime:"+nextPrime(),Toast.LENGTH_LONG);

        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
