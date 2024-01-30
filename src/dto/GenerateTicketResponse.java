package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Ticket;
@Getter
@Setter
@Builder
public class GenerateTicketResponse {
    private Ticket ticket;
}
