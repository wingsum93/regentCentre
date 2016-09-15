package com.ericho.regentcentre;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by steve_000 on 2016/9/7.
 * for project RegentCentre
 * package name com.ericho.regentcentre
 */
public class LocationCheckingSer extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    public class MyBinder extends Binder {
        public LocationCheckingSer getBinder(){
            return LocationCheckingSer.this;
        }
    }
}
