package com.ericho.regentcentre.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.ericho.regentcentre.R;
import com.ericho.regentcentre.adapter.BusRoutePageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by EricH on 7/2/2017.
 */

public class RouteAct extends BaseAct {
    private final String tag = "RouteAct";
    @BindView(R.id.tabLayout) protected TabLayout tabLayout;
    @BindView(R.id.viewpPager)protected ViewPager viewPager;

    private BusRoutePageAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_route);
        setMyView();
    }

    @Override
    public void setMyView() {
        ButterKnife.bind(this);


        pagerAdapter = new BusRoutePageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
