package com.ericho.regentcentre.tmp;

import com.ericho.regentcentre.inter.Location;
import com.ericho.regentcentre.inter.VehicleType;
import com.ericho.regentcentre.model.RouteObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by steve_000 on 6/2/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.tmp
 */

public class RouteGenerator {
    public static List<RouteObject> getTodayList(Calendar calendar,String fromLoc){
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1://sunday
                return new ArrayList<>();
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return getWeekDayRouteList();
            case 7:
                return getWeekEndRouteList();
            default:
                return new ArrayList<>();
        }
    }
    public static List<RouteObject> getWeekDayRouteList() {
        List<RouteObject> res = new ArrayList<>();

        //start from regent centre
        res.add(gen(Location.centre,8,25, VehicleType.big));
        res.add(gen(Location.centre,8,45,VehicleType.big));
        res.add(gen(Location.centre,9,0,VehicleType.big));
        res.add(gen(Location.centre,9,15,VehicleType.big));
        res.add(gen(Location.centre,9,30,VehicleType.big));
        res.add(gen(Location.centre,9,45,VehicleType.normal));
        res.add(gen(Location.centre,10,15,VehicleType.normal));
        res.add(gen(Location.centre,10,45,VehicleType.normal));
        res.add(gen(Location.centre,11,15,VehicleType.normal));
        res.add(gen(Location.centre,11,45,VehicleType.normal));
        res.add(gen(Location.centre,12,30,VehicleType.normal));
        res.add(gen(Location.centre,13,00,VehicleType.normal));
        res.add(gen(Location.centre,13,30,VehicleType.normal));
        res.add(gen(Location.centre,13,45,VehicleType.normal));
        res.add(gen(Location.centre,14,15,VehicleType.normal));
        res.add(gen(Location.centre,14,45,VehicleType.normal));
        res.add(gen(Location.centre,15,15,VehicleType.normal));
        res.add(gen(Location.centre,15,45,VehicleType.normal));
        res.add(gen(Location.centre,16,15,VehicleType.normal));
        res.add(gen(Location.centre,16,45,VehicleType.normal));
        res.add(gen(Location.centre,17,10,VehicleType.normal));
        res.add(gen(Location.centre,17,30,VehicleType.normal));
        res.add(gen(Location.centre,17,45,VehicleType.big));
        res.add(gen(Location.centre,18,00,VehicleType.normal));
        res.add(gen(Location.centre,18,10,VehicleType.big));
        res.add(gen(Location.centre,18,25,VehicleType.big));
        res.add(gen(Location.centre,18,35,VehicleType.big));
        res.add(gen(Location.centre,18,50,VehicleType.big));
        //start MTR station
        res.add(gen(Location.mtrPoint,8,15,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,25,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,35,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,40,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,50,VehicleType.big));
        res.add(gen(Location.mtrPoint,9,0,VehicleType.big));
        res.add(gen(Location.mtrPoint,9,10,VehicleType.big));
        res.add(gen(Location.mtrPoint,9,25,VehicleType.normal));
        res.add(gen(Location.mtrPoint,10,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,10,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,11,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,11,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,12,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,12,45,VehicleType.normal));
        res.add(gen(Location.mtrPoint,13,15,VehicleType.normal));
        res.add(gen(Location.mtrPoint,13,55,VehicleType.normal));
        res.add(gen(Location.mtrPoint,14,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,15,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,15,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,16,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,16,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,16,55,VehicleType.normal));
        res.add(gen(Location.mtrPoint,17,20,VehicleType.normal));
        res.add(gen(Location.mtrPoint,17,35,VehicleType.normal));
        res.add(gen(Location.mtrPoint,17,55,VehicleType.big));
        res.add(gen(Location.mtrPoint,18,10,VehicleType.normal));
        res.add(gen(Location.mtrPoint,18,20,VehicleType.big));
        res.add(gen(Location.mtrPoint,18,30,VehicleType.big));
        return res;
    }
    public static List<RouteObject> getWeekEndRouteList() {
        List<RouteObject> res = new ArrayList<>();

        //start from regent centre
        res.add(gen(Location.centre,8,25,VehicleType.big));
        res.add(gen(Location.centre,8,45,VehicleType.big));
        res.add(gen(Location.centre,9,0,VehicleType.big));
        res.add(gen(Location.centre,9,15,VehicleType.big));
        res.add(gen(Location.centre,9,30,VehicleType.big));
        res.add(gen(Location.centre,9,45,VehicleType.normal));
        res.add(gen(Location.centre,10,15,VehicleType.normal));
        res.add(gen(Location.centre,10,45,VehicleType.normal));
        res.add(gen(Location.centre,11,15,VehicleType.normal));
        res.add(gen(Location.centre,11,45,VehicleType.normal));
        res.add(gen(Location.centre,12,30,VehicleType.normal));
        res.add(gen(Location.centre,13,00,VehicleType.normal));
        res.add(gen(Location.centre,13,10,VehicleType.big));
        res.add(gen(Location.centre,13,20,VehicleType.big));
        res.add(gen(Location.centre,13,30,VehicleType.normal));
        //start MTR station
        res.add(gen(Location.mtrPoint,8,15,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,25,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,35,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,40,VehicleType.big));
        res.add(gen(Location.mtrPoint,8,50,VehicleType.big));
        res.add(gen(Location.mtrPoint,9,0,VehicleType.big));
        res.add(gen(Location.mtrPoint,9,10,VehicleType.big));
        res.add(gen(Location.mtrPoint,9,25,VehicleType.normal));
        res.add(gen(Location.mtrPoint,10,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,10,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,11,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,11,30,VehicleType.normal));
        res.add(gen(Location.mtrPoint,12,00,VehicleType.normal));
        res.add(gen(Location.mtrPoint,12,45,VehicleType.normal));
        return res;
    }
    private static RouteObject gen(@Location String startPoint, int hour, int minute, @VehicleType String vehicleType){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);
        Date targetTime = calendar.getTime();
        return new RouteObject(targetTime,startPoint, vehicleType);
    }
}
