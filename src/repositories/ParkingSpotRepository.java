package repositories;

import lombok.Getter;
import lombok.Setter;
import models.ParkingSpot;

import java.util.Map;
@Getter
@Setter
public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpotMap;
    public ParkingSpot getParkingSpot(int spotId)
    {
        return parkingSpotMap.get(spotId);
    }
}
