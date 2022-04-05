package com.navi.ride.service.impl;

import com.navi.ride.constants.RideConstants;
import com.navi.ride.dto.converter.UserConverter;
import com.navi.ride.dto.request.OfferDetail;
import com.navi.ride.dto.request.SelectRideDetail;
import com.navi.ride.dto.request.UserDetail;
import com.navi.ride.entity.RideStats;
import com.navi.ride.entity.User;
import com.navi.ride.entity.Vehicle;
import com.navi.ride.service.RideInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RideOperation implements RideInterface {

    @Autowired
    private UserConverter userConverter;

    List<User> userData = new ArrayList<>();
    Map<String, List<OfferDetail>> routeMap = new HashMap<>();
    List<String> offerCarCheck = new ArrayList<>();
    Map<String,RideStats> rideOutput = new HashMap<>();

    @Override
    public void addUser(UserDetail userDetail){
        User newUser = userConverter.newUserToUserEntity(userDetail);
        userData.add(newUser);
        rideOutput.put(userDetail.getName(),new RideStats());
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        User userDetail = userData.stream()
                .filter(ele -> (ele.getName()).equals(vehicle.getOwnerName()))
                .findFirst()
                .orElse(null);
        if(userDetail != null){
            (userDetail.getVehicles()).add(vehicle);
        }
    }


    @Override
    public String addOfferRide(OfferDetail offerDetail) {
        if (!offerCarCheck.contains(offerDetail.getVehicleNumber()) && rideOutput.containsKey(offerDetail.getName())){
            int rides = rideOutput.get(offerDetail.getName()).getOfferRide();
            rideOutput.get(offerDetail.getName()).setOfferRide(rides + 1);
            if (routeMap.containsKey(offerDetail.getDestination()))
                routeMap.get(offerDetail.getDestination()).add(offerDetail);
            else
                routeMap.put(offerDetail.getDestination(), new ArrayList<OfferDetail>(){{add(offerDetail);}});

            offerCarCheck.add(offerDetail.getVehicleNumber());
            return RideConstants.rideOfferedSuccess;
        }
        else{
            return RideConstants.rideOfferedFailed;
        }
    }


    //need to throw exception when destination is not available
    @Override
    public String selectOfferRide(SelectRideDetail selectRideDetail){
        for(OfferDetail value:routeMap.get(selectRideDetail.getDestination())) {
            if(value.getOrigin().equals(selectRideDetail.getOrigin()) &&
                selectRideDetail.getPreference().equals("Most Vacant") ||
                    value.getVehicleName().equals(selectRideDetail.getPreferenceValue())) {
                        if(checkRideAllocation(value, selectRideDetail)) return RideConstants.rideTakenSuccess;
                }
        }
        return RideConstants.rideTakenFailed;
    }

    @Override
    public Map<String,RideStats> rideSummary(){
        return rideOutput;
    }

    private Boolean checkRideAllocation(OfferDetail offerDetail, SelectRideDetail selectRideDetail){
        if(offerDetail.getSeatAvailable()>=selectRideDetail.getseatRequired()){
            rideOutput.get(selectRideDetail.getName()).setTakenRide(rideOutput.get(selectRideDetail.getName()).getTakenRide()+1);
            offerDetail.setSeatAvailable(offerDetail.getSeatAvailable()-selectRideDetail.getseatRequired());
            if(offerDetail.getSeatAvailable().equals(0))
                endAvailableRide(offerDetail);

            return true;
        }
        return false;
    }

    private void endAvailableRide(OfferDetail offerDetail){
        routeMap.get(offerDetail.getDestination()).remove(offerDetail);
    }
}
