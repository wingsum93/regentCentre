package com.ericho.regentcentre.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ericho.regentcentre.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by EricH on 24/1/2017.
 */

public class BusScheduleAdapter extends BaseRecyclerAdapter<String,BusScheduleAdapter.ViewHolder> {

    public BusScheduleAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getLayoutInflater().inflate(R.layout.row_bus_schedule,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String i = getItem(position);
        holder.textView.setText("aa");
    }


    public static class ViewHolder extends BaseRecyclerAdapter.ViewHolder {
        @BindView(R.id.text1)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


}
