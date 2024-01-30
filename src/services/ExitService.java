package services;

import exceptions.NoTicketException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.ExitTicket;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import repositories.TicketRepository;
import strategies.CostCalculationStrategy;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@Builder
public class ExitService {
    private ParkingLot parkingLot;

    public ExitService(ParkingLot parkingLot)
    {
        this.parkingLot = parkingLot;

    }

    public ExitTicket createExitTicket(String ticket_id, CostCalculationStrategy strategy)
    {   TicketRepository ticketRepository;
        ticketRepository = this.parkingLot.getTicketRepository();
        String[]parts = ticket_id.split("_");
        String ticket = parts[0];
        int floor = Integer.parseInt(parts[1]);
        int slot = Integer.parseInt(parts[2]);

        Map<Ticket, Vehicle> parkingTickets = ticketRepository.getParkingTickets();
        boolean flag = false;
        Ticket entryTicket = null;
        for(Map.Entry<Ticket,Vehicle> entry:parkingTickets.entrySet())
        {
            if(entry.getKey().getTicketId().equals(ticket_id))
            {
                flag = true;
                //entryTicket = entry;
                Map.Entry<Ticket,Vehicle> e = entry;
                entryTicket = e.getKey();
                break;
            }
        }
        if(entryTicket==null)
        {
            throw new NoTicketException();
        }
        this.parkingLot.getTicketRepository().getParkingTickets().remove(entryTicket);
        String exitTicketId = generateExitTicket(floor,slot);
        LocalDateTime exitTime = LocalDateTime.now();
        Double amount = strategy.calculateAmount(exitTime,entryTicket.getEntryTime());
        ExitTicket exitTicket = ExitTicket.builder().exitTime(exitTime).exitTicketId(exitTicketId).ticket(entryTicket).amount(amount).build();
        this.parkingLot.getExitTicketRepository().saveTicket(exitTicket);
        return exitTicket;
    }

    public String generateExitTicket(int floor_id, int slot_id)
    {
        String parkingTicket = String.valueOf((int)(Math.random()*100)) +"_"+Integer.toString(floor_id)+"_"+Integer.toString(slot_id);

        return parkingTicket;
    }
}
