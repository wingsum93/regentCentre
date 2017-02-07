package com.ericho.regentcentre.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.ericho.regentcentre.annotation.Location;
import com.ericho.regentcentre.fragment.CheckRouteScheduleFrag;

/**
 * Created by EricH on 7/2/2017.
 */

public class BusRoutePageAdapter extends FragmentPagerAdapter {
    public BusRoutePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return CheckRouteScheduleFrag.newInstance(Location.centre);
            case 1:
                return CheckRouteScheduleFrag.newInstance(Location.mtrPoint);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Centre";
            case 1:
                return "Mtr";
            default:
                return "space";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
