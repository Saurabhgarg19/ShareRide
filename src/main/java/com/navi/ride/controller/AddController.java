package com.navi.ride.controller;

import com.navi.ride.constants.RideConstants;
import com.navi.ride.dto.request.UserDetail;
import com.navi.ride.entity.Vehicle;
import com.navi.ride.service.RideInterface;
import com.navi.ride.service.impl.RideOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = RideConstants.add)
public class AddController {

    private static final Logger log = LoggerFactory.getLogger(AddController.class);

    @Autowired
    private RideInterface rideInterface;

    @PostMapping(path = RideConstants.user)
    public String addNewUser(@RequestBody List<UserDetail> userDetail){
        for(UserDetail userDetail1: userDetail)
        rideInterface.addUser(userDetail1);
        return "User Added Successfully";
    }

    @PostMapping(path = RideConstants.vehicle)
    public String addNewVehicle(@RequestBody List<Vehicle> vehicleDetail) {
        for(Vehicle vehicleDetail1 : vehicleDetail)
        rideInterface.addVehicle(vehicleDetail1);
        return "Vehicle Added Successfully";
    }
}
