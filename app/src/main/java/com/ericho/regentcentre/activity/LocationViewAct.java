package com.ericho.regentcentre.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ericho.regentcentre.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by EricH on 20/12/2016.
 */

public class LocationViewAct extends BaseAct implements OnMapReadyCallback {


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

    }


    @Override
    public void setMyView() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    // Include the OnCreate() method here too, as described above.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(22.367227, 114.138023);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Regent Centre in Hong Kong"));
        LatLng mtrUpPoint = new LatLng(22.367248, 114.137885);
        googleMap.addMarker(new MarkerOptions().position(mtrUpPoint)
                .title("Kuan Fong Up Point"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMap.setMinZoomPreference(15.0f);
    }
}
