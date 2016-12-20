package com.ericho.regentcentre.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.ericho.regentcentre.Key;

/**
 * Created by EricH on 20/12/2016.
 */

public class PrefUtil {
    public static void setRegId(Context context, String regid){
        getPreference(context).edit().putString(Key.regid,regid).apply();
    }
    public static SharedPreferences getPreference(Context context){
        return context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }
}
