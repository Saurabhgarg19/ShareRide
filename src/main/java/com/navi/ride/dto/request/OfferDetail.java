package com.navi.ride.dto.request;

public class OfferDetail {
    private String name;
    private String origin;
    private Integer seatAvailable;
    private String vehicleName;
    private String vehicleNumber;
    private String destination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(Integer seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public OfferDetail() {
    }

    @Override
    public String toString() {
        return "OfferDetail{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", seatAvailable=" + seatAvailable +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
