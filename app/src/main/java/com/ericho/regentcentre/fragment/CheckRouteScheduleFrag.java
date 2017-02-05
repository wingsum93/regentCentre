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
import com.ericho.regentcentre.model.RouteObject;
import com.ericho.regentcentre.tmp.RouteGenerator;

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
        List<RouteObject> list = RouteGenerator.getWeekDayRouteList();


        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new BusScheduleAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
    }



}
