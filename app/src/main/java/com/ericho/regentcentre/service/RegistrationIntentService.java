/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ericho.regentcentre.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ericho.regentcentre.Key;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;


public class RegistrationIntentService extends IntentService {

    private static final String TAG = "RegistrationSer";
    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);

        try {
            synchronized (TAG) {
                String token = FirebaseInstanceId.getInstance().getToken();
                FirebaseMessaging.getInstance().subscribeToTopic("all");

                Log.d(TAG, "New Token: " + token);

                updatePreference(token);
                Log.d(TAG, "Registration Token Completed - Local Updated: " + token);



            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
            //sharedPreferences.edit().putBoolean(OTSApp.SENT_TOKEN_TO_SERVER, false).apply();
        }
        //Intent registrationComplete = new Intent(OTSApp.REGISTRATION_COMPLETE);
        //LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }



    private void updatePreference(String token) {
        //Save back to preference
        SharedPreferences sharedPreferences = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Key.regId, token);
        editor.apply();
    }
}
