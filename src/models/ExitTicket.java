package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@Builder
public class ExitTicket {
    private String exitTicketId;
    private Ticket ticket;
    private Double amount;
    private LocalDateTime exitTime;
}
