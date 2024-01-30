package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@Builder
public class Ticket {
    private String ticketId;
    private LocalDateTime entryTime ;
    private ParkingSpot parkingSpot;

}
