package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
    private int parkingSpotId;
    private int floorId;
    private String spotVehicleType;
    private Vehicle vehicle;
    public ParkingSpot(int spotId, int floorId,String type, Vehicle vehicle)
    {   this.floorId = floorId;
        this.parkingSpotId = spotId;
        this.spotVehicleType = type;
        this.vehicle = vehicle;
    }
}
