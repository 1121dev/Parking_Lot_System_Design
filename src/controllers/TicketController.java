package controllers;

import dto.GenerateTicketRequest;
import dto.GenerateTicketResponse;
import models.ParkingLot;
import models.Ticket;
import services.EntryService;

public class TicketController {
    private EntryService entryService;
    public TicketController(EntryService entryService)
    {
        this.entryService = entryService;
    }
    public GenerateTicketResponse generateTicket(GenerateTicketRequest request)
    {

        Ticket ticket = entryService.createTicket(request.getVehicle());

        // Rendering the response
        return GenerateTicketResponse.builder().ticket(ticket).build();
    }

}
