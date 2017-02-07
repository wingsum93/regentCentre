package com.ericho.regentcentre.model;

import com.ericho.regentcentre.annotation.Location;
import com.ericho.regentcentre.annotation.VehicleType;

import java.util.Date;

/**
 * Created by steve_000 on 19/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.model
 */

public class RouteObject {

    private Date startTime;
    @Location
    private String startPoint;
    @VehicleType
    private String vehicleType;

    public RouteObject(){}
    public RouteObject(Date startTime, @Location String startPoint, @VehicleType String vehicleType){
        this.startTime = startTime;
        this.startPoint = startPoint;
        this.vehicleType = vehicleType;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
