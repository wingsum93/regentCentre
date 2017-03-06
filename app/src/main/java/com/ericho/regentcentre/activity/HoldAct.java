package com.ericho.regentcentre.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.ericho.regentcentre.ActivityListener;
import com.ericho.regentcentre.R;
import com.ericho.regentcentre.fragment.BaseFrag;
import com.ericho.regentcentre.fragment.CheckRouteScheduleFrag;
import com.ericho.regentcentre.annotation.Location;

/**
 * Created by steve_000 on 22/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.activity
 */

public class HoldAct extends BaseHoldAct implements ActivityListener ,SearchView.OnQueryTextListener {
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
        try{
            BaseFrag baseFrag = (BaseFrag) fragment;
            return baseFrag.onQueryTextSubmit(query);
        }catch (ClassCastException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
