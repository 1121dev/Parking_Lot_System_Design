package services;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;

public class ParkingLotDisplayService {
    public void display_free_cnt(ParkingLot parkingLot, String type)
    {
        for(int i = 1; i<=parkingLot.getTot_floors(); i++)
        {
            int cnt = 0;
            ParkingFloor floor = parkingLot.getParkingFloorRepository().getFloor(i);
            for(int j = 1; j<=floor.getTot_slots();j++)
            {
                ParkingSpot slot = floor.getParkingSpotRepository().getParkingSpot(j);

                if (slot.getSpotVehicleType().equals(type))
                    if (slot.getVehicle() == null) {
                        cnt++;
                    }


            }
            System.out.println("No. of free slots for "+type+" on floor "+i+": "+cnt);
        }
    }

    public void display_free_slots(ParkingLot parkingLot,String type)
    {
        for(int i = 1; i<=parkingLot.getTot_floors(); i++)
        {
            StringBuilder free_slots = new StringBuilder();
            ParkingFloor floor = parkingLot.getParkingFloorRepository().getFloor(i);
            for(int j = 1; j<=floor.getTot_slots(); j++)
            {
                ParkingSpot slot = floor.getParkingSpotRepository().getParkingSpot(j);
                if(slot.getSpotVehicleType().equals(type))
                {
                    if(slot.getVehicle() == null)
                        free_slots.append(Integer.toString(j)).append(",");
                }


            }
            System.out.println("Free slots for "+type+" on floor "+i+" :"+free_slots);

        }
    }

    public void display_occupied_slots(ParkingLot parkingLot, String type)
    {
        for(int i = 1; i<=parkingLot.getTot_floors(); i++)
        {
            StringBuilder occupied_slots = new StringBuilder();
            ParkingFloor floor = parkingLot.getParkingFloorRepository().getFloor(i);
            for(int j = 1; j<=floor.getTot_slots(); j++)
            {
                ParkingSpot slot = floor.getParkingSpotRepository().getParkingSpot(j);
                if(slot.getSpotVehicleType().equals(type))
                {
                    if(slot.getVehicle() != null)
                        occupied_slots.append(Integer.toString(j)).append(",");
                }


            }
            System.out.println("Occupied slots for "+type+" on floor "+i+" :"+occupied_slots);

        }
    }
}
