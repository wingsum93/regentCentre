package com.ericho.regentcentre.service;

import android.util.Log;

import com.ericho.regentcentre.util.PrefUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by steve_000 on 17/12/2016.
 * for project anroidHealth
 * package name com.example.wayne.androidhealth
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("MyFirebaseInstanc", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        PrefUtil.setRegId(this,refreshedToken);


    }
}
