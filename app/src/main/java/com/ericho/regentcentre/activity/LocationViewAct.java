package com.ericho.regentcentre.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ericho.regentcentre.R;

/**
 * Created by EricH on 20/12/2016.
 */

public class LocationViewAct extends BaseAct {


    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,LocationViewAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_location_view);
        setMyView();
        setListener();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void setMyView() {

    }
}
