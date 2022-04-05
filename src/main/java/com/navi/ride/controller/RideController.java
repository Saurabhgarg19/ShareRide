package com.navi.ride.controller;

import com.navi.ride.constants.RideConstants;
import com.navi.ride.dto.request.OfferDetail;
import com.navi.ride.dto.request.SelectRideDetail;
import com.navi.ride.entity.RideStats;
import com.navi.ride.service.RideInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = RideConstants.ride)
public class RideController {
    private static final Logger log = LoggerFactory.getLogger(AddController.class);

    @Autowired
    private RideInterface rideInterface;

    @PostMapping(path = RideConstants.offer)
    public List<String> offerRide(@RequestBody List<OfferDetail> offerDetail){
        List<String> responseList = new ArrayList<>();
        for(OfferDetail offerDetail1: offerDetail)
         responseList.add(rideInterface.addOfferRide(offerDetail1));

        return responseList;
    }

    @PostMapping(path = RideConstants.select)
    public String selectRide(@RequestBody SelectRideDetail selectRideDetail){
        return rideInterface.selectOfferRide(selectRideDetail);
    }

    @GetMapping(path = RideConstants.print)
    public Map<String, RideStats> printRideSummary(){
        return rideInterface.rideSummary();
    }
}
