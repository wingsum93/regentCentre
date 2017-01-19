package com.ericho.regentcentre.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.ericho.regentcentre.ActivityListener;

/**
 * Created by EricH on 20/12/2016.
 */

public abstract class BaseFrag extends Fragment {
    private static final String tag = "BaseFrag";
    private ActivityListener activityListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachContext(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onAttachContext(activity);
    }
    
    private void onAttachContext(Context context){
        try{
            activityListener = (ActivityListener) getActivity();
        }catch (ClassCastException e){
            Log.w(tag,"must implement activity listener in act.");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setMyView();
    }

    abstract void setMyView();

}
