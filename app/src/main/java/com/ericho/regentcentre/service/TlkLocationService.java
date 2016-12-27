package com.ericho.regentcentre.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.widget.Toast;

import com.ericho.regentcentre.Key;
import com.ericho.regentcentre.util.BroadcastUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.List;
import java.util.Locale;


/**
 * Created by KenW on 7/22/2015.
 */
public class TlkLocationService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{
    private static final String t = "TlkLocationService";
    private Location mLastLocation;
    // use the websmithing defaultUploadWebsite for testing and then check your
// location with your browser here: https://www.websmithing.com/gpstracker/displaymap.php
    private String defaultUploadWebsite;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    private boolean currentlyProcessingLocation = false;
    private LocationRequest locationRequest;
    private GoogleApiClient locationClient;
    private boolean haveGooglePlay;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(t, "Received start id " + startId + ": " + intent);
        haveGooglePlay=checkPlayServices(); // check hkphone or china phone
        Log.i(t,"have googlePlay? "+haveGooglePlay);
        boolean googlelocationwork=false;
        //@@ ### check normal gps
        //        startTraditionalGps();ApiClient.getInstance().saveLocation(getBaseContext());updateLastUpdateTime();//save to web
        if (haveGooglePlay) {
//        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == ConnectionResult.SUCCESS) {
            //locationClient = new GoogleApiClient(this, this, this);
            locationClient = new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    locationClient);
            if (mLastLocation != null) {
                googlelocationwork=true;
            }
        }
        Log.i(t, "have googlenetwork? " + googlelocationwork);
        if (googlelocationwork) {
            if (!locationClient.isConnected() || !locationClient.isConnecting()) {
                locationClient.connect();
            }
        }else{
            Log.e(t, "unable to connect to google play services.Use network@");

            if(getApplicationContext()!=null){
                startTraditionalGps();

            }

        }
        stop();
        return START_NOT_STICKY; // need manual restart.
    }

    private void stop(){
        try{
            locationClient.unregisterConnectionCallbacks(this);
            locationClient.unregisterConnectionFailedListener(this);
            locationClient.disconnect();
        } catch(Exception e){
            Log.e(t,"client fail ");
        }

        this.stopSelf();
    }

    @RequiresPermission(anyOf = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    })
    private void startTraditionalGps() {// check gps without googleplay
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if(locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER) && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            String provider = LocationManager.NETWORK_PROVIDER;
            Log.d(t,"provider name:"+provider);
            locationManager.requestLocationUpdates(provider, 5000, 500, mListener);// for 5s
            Location mLastLocation = locationManager.getLastKnownLocation(provider);

            if(mLastLocation!=null) outBroadcastLocation(mLastLocation);//write it into pref.
            // check if enabled and if not send user to the GSP settings
            // Better solution would be to display a dialog and suggesting to
            // go to the settings
            locationManager.removeUpdates(mListener);
//        service.req
        }


    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Called by Location Services when the request to connect the
     * client finishes successfully. At this point, you can
     * request the current location or start periodic updates
     */
    @Override
    public void onConnected(Bundle bundle) {
        Log.d(t, "onConnected and get location");

        //locationClient.requestLocationUpdates(locationRequest, this);
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                locationClient);
        if(mLastLocation!=null) {
            Log.d(t," location client not null");
            outBroadcastLocation(mLastLocation);
        }else{
            Log.d(t," location client null");
        }
        Log.d(t, "write into pre.");
        Log.d(t, "finish connect");


    }

    @Override
    public void onConnectionSuspended(int i) {
        locationClient.connect();
    }

//    /**
//     * Called by Location Services if the connection to the
//     * location client drops because of an error.
//     */
//    @Override
//    public void onDisconnected() {
//        Log.e(t, "onDisconnected");
//
//        stopLocationUpdates();
//        stopSelf();
//    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e(t, "onConnectionFailed");
        stop();
    }

    private boolean checkPlayServices() {
        Log.d(t, "start to check google play");
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                Toast.makeText(getApplication(),
                        "Google play service not work", Toast.LENGTH_LONG)
                        .show();

//                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
//                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplication(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
            }
            return false;
        }
        return true;
    }
    private LocationListener mListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(t, location.toString());
                outBroadcastLocation(location);//  write to pref.

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d(t,"provider disable");
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(t,"provider disable");
            }
        };

    private void outBroadcastLocation(@NonNull Location mLastLocation){
//        SharedPreferences.Editor editor = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit();
        //// TODO: 22/12/2016 broadcast location
        Log.d(t, "write loc in pref." + mLastLocation.toString());

        BroadcastUtil.OnLocationUpdate(this,mLastLocation);
        if(haveGooglePlay)decodeLocationAddress(mLastLocation);//find add need googleplay


    }
    private void decodeLocationAddress(Location location){// dec address and write into pref.
        SharedPreferences.Editor editor = getSharedPreferences(getPackageName(),MODE_PRIVATE).edit();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            Address obj = addresses.get(0);
            String add = "";
            for (int i = 0; i <= obj.getMaxAddressLineIndex();i++){
                add += obj.getAddressLine(i);
            }

            editor.apply();
        }catch (Exception e){
            Log.e(t,"exception in decode"+e.getMessage());
        }
        editor.apply();
    }

    private void d(String st){
        Log.d("locationSer",st);
    }
}