package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.ExitTicket;
@Getter
@Setter
@Builder
public class GenerateExitTicketResponse {
    private ExitTicket exitTicket;
}
