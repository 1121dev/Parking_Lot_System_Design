package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String colour;

    public Vehicle(String vehicleNumber, String vehicleType, String colour) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.colour = colour;
    }
}
