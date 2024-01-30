package repositories;

import lombok.Getter;
import lombok.Setter;
import models.ExitTicket;
import models.Ticket;
import models.Vehicle;

import java.util.Map;
@Getter
@Setter
public class ExitTicketRepository {
    private Map<ExitTicket, Ticket> parkingExitTickets;
    public void saveTicket(ExitTicket exitTicket)
    {
        parkingExitTickets.put(exitTicket,exitTicket.getTicket());
    }
}
