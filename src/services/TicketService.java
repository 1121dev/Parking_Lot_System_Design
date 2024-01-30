package services;

import models.ParkingLot;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository)
    {
        this.ticketRepository = ticketRepository;
    }
    public Ticket createTicket(Vehicle vehicle, ParkingSpot spot)
    {
        //System.out.println(spot.getFloorId());
        Ticket ticket =  Ticket.builder()
                .ticketId(generateTicket(spot.getFloorId(), spot.getParkingSpotId()))
                .entryTime(LocalDateTime.now())
                .parkingSpot(spot)
        .build();
        this.ticketRepository.saveTicket(ticket);
        return ticket;
    }

    public String generateTicket(int floor_id, int slot_id)
    {
        String parkingTicket = String.valueOf((int)(Math.random()*100)) +"_"+Integer.toString(floor_id)+"_"+Integer.toString(slot_id);

        return parkingTicket;
    }
}
