package com.ericho.regentcentre;

import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Test;

/**
 * Created by steve_000 on 29/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre
 */

public class StringTest extends AndroidTestCase {

    @Test
    public void xx(){
        int  sss =0;
        String output = getContext().getString(R.string.format_2_digit,sss);
        Log.d("string test",output);
    }
}
