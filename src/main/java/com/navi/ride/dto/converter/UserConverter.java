package com.navi.ride.dto.converter;

import com.navi.ride.dto.request.UserDetail;
import com.navi.ride.entity.User;
import com.navi.ride.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserConverter {
    public User newUserToUserEntity(UserDetail newUserRequest){
        User user = new User();
        user.setName(newUserRequest.getName());
        user.setAge(newUserRequest.getAge());
        user.setGender(newUserRequest.getGender());
        user.setVehicles(new ArrayList<Vehicle>());
        return user;
    }
}
