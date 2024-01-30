package services;

import exceptions.NoSpotAvailableException;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import repositories.ParkingFloorRepository;
import strategies.SpotFindingStrategy;

public class SlotAllocationService {
    private ParkingFloorRepository parkingFloorRepository;
    private SpotFindingStrategy strategy;
    public SlotAllocationService(SpotFindingStrategy strategy)
    {
        this.strategy = strategy;
    }
    public ParkingSpot findSpot(ParkingLot parkingLot,Vehicle vehicle)
    {
        this.parkingFloorRepository = parkingLot.getParkingFloorRepository();
        ParkingSpot spot =  this.strategy.getSpot(this.parkingFloorRepository,vehicle);

        if(spot==null)
            throw new NoSpotAvailableException();
        spot.setVehicle(vehicle);
        return spot;
    }
}
