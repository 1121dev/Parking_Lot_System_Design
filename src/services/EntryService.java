package services;

import exceptions.NoSpotAvailableException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.ParkingLot;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import strategies.DefaultSpotFindingStrategy;

@Getter
@Setter
@Builder
public class EntryService {
    private ParkingLot parkingLot;

    public EntryService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket createTicket(Vehicle vehicle)
    {

        SlotAllocationService slotAllocationService = new SlotAllocationService(new DefaultSpotFindingStrategy());
        ParkingSpot availableSpot = slotAllocationService.findSpot(this.parkingLot,vehicle);
        if(availableSpot==null)
            throw new NoSpotAvailableException();

        TicketService ticketService = new TicketService(this.parkingLot.getTicketRepository());
        Ticket ticket = ticketService.createTicket(vehicle,availableSpot);
        return ticket;
    }
}
