package com.ericho.regentcentre.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ericho.regentcentre.R;
import com.ericho.regentcentre.inter.AdapterBeauty;
import com.ericho.regentcentre.model.RouteObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * Created by EricH on 24/1/2017.
 */

public class BusScheduleAdapter extends BaseRecyclerAdapter<RouteObject,BusScheduleAdapter.ViewHolder>
    implements AdapterBeauty {
    private SimpleDateFormat df = new SimpleDateFormat("hh:mm");
    public BusScheduleAdapter(Context context, List<RouteObject> list) {
        super(context, list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getLayoutInflater().inflate(R.layout.row_bus_schedule,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RouteObject i = getItem(position);

        setText(holder.type, i.getVehicleType());
        setText(holder.other, i.getStartPoint());
        setText(holder.time, getDateString(i.getStartTime()));
    }

    @Override
    public void setText(TextView textView, String s) {
        if (s == null) {
            s = "";
        }
        textView.setText(s);
    }
    private @Nullable String getDateString(Date date){
        if (date == null) {
            return null;
        }else {
            return df.format(date);
        }
    }


    public static class ViewHolder extends BaseRecyclerAdapter.ViewHolder {
        @BindView(R.id.type) TextView type;
        @BindView(R.id.time) TextView time;
        @BindView(R.id.other) TextView other;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


}
