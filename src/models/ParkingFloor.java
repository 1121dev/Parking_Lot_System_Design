package models;
import lombok.Getter;
import lombok.Setter;
import repositories.ParkingFloorRepository;
import repositories.ParkingSpotRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
@Getter
@Setter
public class ParkingFloor {
    private int floorId;
    private Map<Integer,ParkingSpot>parkingSpotMap;
    private int tot_slots;
    private int spot_id;
    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
    public ParkingFloor(int floorId, int tot_slots)
    {
        this.floorId = floorId;
        this.tot_slots = tot_slots;
        this.spot_id = 1;
        this.parkingSpotMap = new HashMap<>();
        for(int i = 1; i<=tot_slots; i++)
        {
            String spotType;
            System.out.println("Enter spot type for floor "+this.floorId+" and spotId :"+this.spot_id);
            Scanner sc = new Scanner(System.in);
            spotType = sc.next();
            this.parkingSpotMap.put(this.spot_id,new ParkingSpot(this.spot_id,this.floorId,spotType,null));
            this.spot_id++;
        }
        this.parkingSpotRepository.setParkingSpotMap(parkingSpotMap);
    }
}
