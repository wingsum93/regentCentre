package com.ericho.regentcentre.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by EricH on 20/12/2016.
 */

public abstract class BaseFrag extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachContext(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
    }
    
    private void onAttachContext(Context context){
        //// TODO: 20/12/2016  
    }
}
