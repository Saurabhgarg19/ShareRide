package com.navi.ride.dto.request;

public class SelectRideDetail {
    private String name;
    private String origin;
    private String destination;
    private Integer seatRequired;
    private String preference;
    private String preferenceValue;

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getseatRequired() {
        return seatRequired;
    }

    public String getPreference() {
        return preference;
    }

    public String getPreferenceValue() {
        return preferenceValue;
    }

    public SelectRideDetail() {
    }

    @Override
    public String toString() {
        return "SelectRideDetail{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", seatRequired=" + seatRequired +
                ", preference='" + preference + '\'' +
                ", preferenceValue='" + preferenceValue + '\'' +
                '}';
    }
}
