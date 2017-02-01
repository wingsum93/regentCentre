package com.ericho.regentcentre.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ericho.regentcentre.R;
import com.ericho.regentcentre.adapter.BusScheduleAdapter;
import com.ericho.regentcentre.inter.VehicleType;
import com.ericho.regentcentre.model.RouteObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steve_000 on 19/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.fragment
 */

public class CheckRouteScheduleFrag extends BaseFrag {

    private static final String tag = "CheckRouteScheduleFrag";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private BusScheduleAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static BaseFrag newInstance(){
        CheckRouteScheduleFrag frag = new CheckRouteScheduleFrag();
        Bundle bundle = new Bundle();
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_check_route,container,false);
        ButterKnife.bind(this,v);
        return v;
    }



    @Override
    void setMyView() {
        List<RouteObject> list = getWeekDayRouteList();


        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new BusScheduleAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
    }

    private List<RouteObject> getWeekDayRouteList() {
        List<RouteObject> res = new ArrayList<>();
        String centre = "Regent Centre";
        String mtrPoint = "MTR Station";
        //start from regent centre
        res.add(gen(centre,8,25,VehicleType.big));
        res.add(gen(centre,8,45,VehicleType.big));
        res.add(gen(centre,9,0,VehicleType.big));
        res.add(gen(centre,9,15,VehicleType.big));
        res.add(gen(centre,9,30,VehicleType.big));
        res.add(gen(centre,9,45,VehicleType.normal));
        res.add(gen(centre,10,15,VehicleType.normal));
        res.add(gen(centre,10,45,VehicleType.normal));
        res.add(gen(centre,11,15,VehicleType.normal));
        res.add(gen(centre,11,45,VehicleType.normal));
        res.add(gen(centre,12,30,VehicleType.normal));
        res.add(gen(centre,13,00,VehicleType.normal));
        res.add(gen(centre,13,30,VehicleType.normal));
        res.add(gen(centre,13,45,VehicleType.normal));
        res.add(gen(centre,14,15,VehicleType.normal));
        res.add(gen(centre,14,45,VehicleType.normal));
        res.add(gen(centre,15,15,VehicleType.normal));
        res.add(gen(centre,15,45,VehicleType.normal));
        res.add(gen(centre,16,15,VehicleType.normal));
        res.add(gen(centre,16,45,VehicleType.normal));
        res.add(gen(centre,17,10,VehicleType.normal));
        res.add(gen(centre,17,30,VehicleType.normal));
        res.add(gen(centre,17,45,VehicleType.big));
        res.add(gen(centre,18,00,VehicleType.normal));
        res.add(gen(centre,18,10,VehicleType.big));
        res.add(gen(centre,18,25,VehicleType.big));
        res.add(gen(centre,18,35,VehicleType.big));
        res.add(gen(centre,18,50,VehicleType.big));
        //start MTR station
        res.add(gen(mtrPoint,8,15,VehicleType.big));
        res.add(gen(mtrPoint,8,25,VehicleType.big));
        res.add(gen(mtrPoint,8,35,VehicleType.big));
        res.add(gen(mtrPoint,8,40,VehicleType.big));
        res.add(gen(mtrPoint,8,50,VehicleType.big));
        res.add(gen(mtrPoint,9,0,VehicleType.big));
        res.add(gen(mtrPoint,9,10,VehicleType.big));
        res.add(gen(mtrPoint,9,25,VehicleType.normal));
        res.add(gen(mtrPoint,10,00,VehicleType.normal));
        res.add(gen(mtrPoint,10,30,VehicleType.normal));
        res.add(gen(mtrPoint,11,00,VehicleType.normal));
        res.add(gen(mtrPoint,11,30,VehicleType.normal));
        res.add(gen(mtrPoint,12,00,VehicleType.normal));
        res.add(gen(mtrPoint,12,45,VehicleType.normal));
        res.add(gen(mtrPoint,13,15,VehicleType.normal));
        res.add(gen(mtrPoint,13,55,VehicleType.normal));
        res.add(gen(mtrPoint,14,30,VehicleType.normal));
        res.add(gen(mtrPoint,15,00,VehicleType.normal));
        res.add(gen(mtrPoint,15,30,VehicleType.normal));
        res.add(gen(mtrPoint,16,00,VehicleType.normal));
        res.add(gen(mtrPoint,16,30,VehicleType.normal));
        res.add(gen(mtrPoint,16,55,VehicleType.normal));
        res.add(gen(mtrPoint,17,20,VehicleType.normal));
        res.add(gen(mtrPoint,17,35,VehicleType.normal));
        res.add(gen(mtrPoint,17,55,VehicleType.big));
        res.add(gen(mtrPoint,18,10,VehicleType.normal));
        res.add(gen(mtrPoint,18,20,VehicleType.big));
        res.add(gen(mtrPoint,18,30,VehicleType.big));
        return res;
    }
    private RouteObject gen(String startPoint,int hour,int minute,@VehicleType String vehicleType){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);
        Date targetTime = calendar.getTime();
        return new RouteObject(targetTime,startPoint, vehicleType);
    }
}
