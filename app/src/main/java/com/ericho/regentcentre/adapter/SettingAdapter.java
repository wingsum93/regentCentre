package com.ericho.regentcentre.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ericho.regentcentre.model.SettingObject;

import java.util.List;

/**
 * Created by EricH on 1/3/2017.
 */

public class SettingAdapter extends BaseRecyclerAdapter<SettingObject,SettingAdapter.ViewHolder> {


    public SettingAdapter(Context context, List<SettingObject> list) {
        super(context, list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
