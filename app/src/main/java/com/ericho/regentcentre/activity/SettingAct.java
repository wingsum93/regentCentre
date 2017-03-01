package com.ericho.regentcentre.activity;

import android.app.AlarmManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;

import com.ericho.regentcentre.R;
import com.ericho.regentcentre.adapter.SettingAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by EricH on 14/2/2017.
 */

public class SettingAct extends BaseAct {
    private final String tag = "SettingAct";

    @BindView(R.id.recyclerView) protected RecyclerView recyclerView;
    @BindView(R.id.coordinatorLayout) protected CoordinatorLayout coordinatorLayout;

    private SettingAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_setting);
        ButterKnife.bind(this);
        setMyView();
    }

    @Override
    public void setMyView() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmManager.set



    }
}
