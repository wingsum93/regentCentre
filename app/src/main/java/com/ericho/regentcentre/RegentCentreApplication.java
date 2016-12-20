package com.ericho.regentcentre;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.google.firebase.FirebaseApp;

import org.xutils.x;

/**
 * Created by EricH on 20/12/2016.
 */

public class RegentCentreApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        Stetho.initializeWithDefaults(this);
        FirebaseApp.initializeApp(this);
    }
}
