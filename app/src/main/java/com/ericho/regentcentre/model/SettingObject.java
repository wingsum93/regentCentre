package com.ericho.regentcentre.model;

import android.support.annotation.StringRes;

/**
 * Created by EricH on 1/3/2017.
 */

public class SettingObject {
    private @StringRes int stringInt;
    private String key ;

    public @StringRes int getStringInt() {
        return stringInt;
    }

    public void setStringInt(@StringRes int stringInt) {
        this.stringInt = stringInt;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
