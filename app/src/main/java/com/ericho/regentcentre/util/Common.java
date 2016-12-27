package com.ericho.regentcentre.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.ericho.regentcentre.Key;
import com.ericho.regentcentre.RegentCentreApp;

/**
 * Created by steve_000 on 22/12/2016.
 * for project RegentCentre
 * package name com.ericho.regentcentre.util
 */

public class Common {
    public static SharedPreferences getPreference(){
        Context context = RegentCentreApp.getContext();
        return context.getSharedPreferences(Key.pref_name,Context.MODE_PRIVATE);
    }
    public static void writeStringPrefValue(String key,@NonNull String value){
        SharedPreferences preferences = getPreference();
        preferences.edit().putString(key, value).apply();
    }
}
