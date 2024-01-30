package controllers;

import dto.GenerateExitTicketRequest;
import dto.GenerateExitTicketResponse;
import exceptions.NoTicketException;
import models.ExitTicket;
import strategies.DefaultCostCalcuationStrategy;
import services.ExitService;

public class ExitController {
    private ExitService exitService;
    public ExitController(ExitService exitService)
    {
        this.exitService = exitService;
    }

    public GenerateExitTicketResponse generateExitTicket(GenerateExitTicketRequest request)
    {
        ExitTicket exitTicket = this.exitService.createExitTicket(request.getEntryTicketId(),new DefaultCostCalcuationStrategy());
        if(exitTicket==null)
            throw new NoTicketException();
        return GenerateExitTicketResponse.builder().exitTicket(exitTicket).build();
    }
}
