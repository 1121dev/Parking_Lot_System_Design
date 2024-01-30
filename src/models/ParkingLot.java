package models;

import lombok.Getter;
import lombok.Setter;
import repositories.ExitTicketRepository;
import repositories.ParkingFloorRepository;
import repositories.PaymentRepository;
import repositories.TicketRepository;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class ParkingLot {
    private String parkingLotId;

    private Map<Integer,ParkingFloor> parkingFloorMap;
    private Map<Ticket,Vehicle>parkingTickets;
    private Map<ExitTicket,Ticket>parkingExitTickets;
    private Map<ExitTicket,Invoice> paymentsRecord;
    private int tot_floors;
    private int tot_slots;
    private int floorNumber;
    private ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
    private TicketRepository ticketRepository = new TicketRepository();
    private ExitTicketRepository exitTicketRepository = new ExitTicketRepository();
    private PaymentRepository paymentRepository = new PaymentRepository();
    public ParkingLot(int tot_floors, int slots, String parkingLotId)
    {
        this.tot_floors = tot_floors;
        this.tot_slots = slots*this.tot_floors;
        this.parkingLotId = parkingLotId;
        this.floorNumber = 1;
        this.parkingFloorMap = new HashMap<>();
        for(int i = 1; i<=tot_floors; i++)
        {
            parkingFloorMap.put(this.floorNumber,new ParkingFloor(this.floorNumber,slots));
            this.floorNumber++;
        }
        this.parkingFloorRepository.setParkingFloorMap(parkingFloorMap);
        this.ticketRepository.setParkingTickets(new HashMap<>());
        this.exitTicketRepository.setParkingExitTickets(new HashMap<>());
        this.paymentRepository.setPaymentsRecord(new HashMap<>());
    }

}
