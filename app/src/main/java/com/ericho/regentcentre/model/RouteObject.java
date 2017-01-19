package com.ericho.regentcentre.model;

import java.util.Date;

/**
 * Created by steve_000 on 19/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.model
 */

public class RouteObject {

    private Date startTime;
    private String startPoint;

    public RouteObject(){}
    public RouteObject(Date startTime,String startPoint){
        this.startTime = startTime;
        this.startPoint = startPoint;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
}
