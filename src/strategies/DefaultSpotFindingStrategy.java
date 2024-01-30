package strategies;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Vehicle;
import repositories.ParkingFloorRepository;
import repositories.ParkingSpotRepository;
import strategies.SpotFindingStrategy;

import java.util.Map;

public class DefaultSpotFindingStrategy implements SpotFindingStrategy {
    //finds the first available slot from bottom to top floor based on the vehicle type
    public ParkingSpot getSpot(ParkingFloorRepository repository, Vehicle vehicle)
    {
        Map<Integer, ParkingFloor> parkingFloorMap = repository.getParkingFloorMap();
        int totFloor = parkingFloorMap.size();
        for(int i = 1; i<=totFloor; i++)
        {
            ParkingSpotRepository parkingSpotRepository = parkingFloorMap.get(i).getParkingSpotRepository();
            Map<Integer,ParkingSpot>parkingSpotMap = parkingSpotRepository.getParkingSpotMap();
            int totSpots = parkingSpotMap.size();
            for(int j = 1; j<=totSpots; j++)
            {   ParkingSpot spot = parkingSpotMap.get(j);
                if(spot.getSpotVehicleType().equals(vehicle.getVehicleType()))
                {
                    if(spot.getVehicle()==null)
                    {

                        return spot;
                    }

                }
            }
        }
        return null;
    }
}
