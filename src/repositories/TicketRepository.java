package repositories;

import lombok.Getter;
import lombok.Setter;
import models.Ticket;
import models.Vehicle;

import java.util.Map;
@Getter
@Setter
public class TicketRepository {
    private Map<Ticket,Vehicle> parkingTickets;
    public void saveTicket(Ticket ticket)
    {
        parkingTickets.put(ticket,ticket.getParkingSpot().getVehicle());
    }


}
