package services;

import lombok.Getter;
import lombok.Setter;
import models.ParkingLot;

import java.util.Scanner;
@Getter
@Setter
public class InitializeParkingLotService {
    private ParkingLot parkingLot;

    public ParkingLot createParkingLot()
    {
        int floors, slots;
        Scanner sc = new Scanner(System.in);
        String parking_lot_id;
        System.out.println("Enter parking lot ID, the number of floors and slots for each floor");
        parking_lot_id = sc.nextLine();
        floors = sc.nextInt();
        slots = sc.nextInt();
        this.parkingLot = new ParkingLot(floors,slots,parking_lot_id);
        return parkingLot;
    }
}
