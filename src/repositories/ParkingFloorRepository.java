package repositories;

import lombok.Getter;
import lombok.Setter;
import models.ParkingFloor;

import java.util.Map;
@Getter
@Setter
public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;
    public ParkingFloor getFloor(int floorId)
    {
        return parkingFloorMap.get(floorId);
    }
}
