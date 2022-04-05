package com.navi.ride.service;

import com.navi.ride.dto.request.OfferDetail;
import com.navi.ride.dto.request.SelectRideDetail;
import com.navi.ride.dto.request.UserDetail;
import com.navi.ride.entity.RideStats;
import com.navi.ride.entity.Vehicle;

import java.util.Map;

public interface RideInterface {

    void addUser(UserDetail user);
    void addVehicle(Vehicle vehicle);
    String addOfferRide(OfferDetail offerDetail);
    String selectOfferRide(SelectRideDetail selectRideDetail);
    Map<String,RideStats> rideSummary();
}
