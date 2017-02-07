package com.ericho.regentcentre.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ericho.regentcentre.ActivityListener;
import com.ericho.regentcentre.R;
import com.ericho.regentcentre.fragment.CheckRouteScheduleFrag;
import com.ericho.regentcentre.annotation.Location;

/**
 * Created by steve_000 on 22/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.activity
 */

public class HoldAct extends BaseHoldAct implements ActivityListener {
    private final String tag = "HoldAct";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_hold);
        setMyView();
    }

    @Override
    public void setMyView() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,CheckRouteScheduleFrag.newInstance(Location.centre)).commit();

    }

    @Override
    public void back() {
        getSupportFragmentManager().popBackStack();
    }
}
