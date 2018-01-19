package com.example.admin.testserviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    int n=2;
    boolean prime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
    class SendObject extends Binder {
        MyService getObject(){
            return MyService.this;
        }
    }
    public int nextPrimeMine() {
        while (!prime(n)) {
            n++;
        }
        int m=n;
        n++;
        return m;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this,"Next Prime:"+nextPrimeMine(),Toast.LENGTH_LONG);
        n++;
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return new MyPrimeInterface.Stub() {


           @Override
           public int nextPrime() throws RemoteException {
               return nextPrimeMine();
           }
       };
    }
}
