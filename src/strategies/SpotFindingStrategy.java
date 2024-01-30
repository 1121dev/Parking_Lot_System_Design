package strategies;

import models.ParkingSpot;
import models.Vehicle;
import repositories.ParkingFloorRepository;

public interface SpotFindingStrategy {
    public ParkingSpot getSpot(ParkingFloorRepository parkingFloorRepository, Vehicle vehicle);
}
