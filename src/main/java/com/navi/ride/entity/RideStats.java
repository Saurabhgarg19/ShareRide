package com.navi.ride.entity;

public class RideStats {
    private Integer takenRide = 0;
    private Integer offerRide = 0;

    public Integer getTakenRide() {
        return takenRide;
    }

    public void setTakenRide(Integer takenRide) {
        this.takenRide = takenRide;
    }

    public Integer getOfferRide() {
        return offerRide;
    }

    public void setOfferRide(Integer offerRide) {
        this.offerRide = offerRide;
    }

    public RideStats() {
    }

    @Override
    public String toString() {
        return "RideStats{" +
                "takenRide=" + takenRide +
                ", offerRide=" + offerRide +
                '}';
    }
}
