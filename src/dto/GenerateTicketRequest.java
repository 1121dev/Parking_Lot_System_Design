package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Vehicle;
@Getter
@Setter
@Builder
public class GenerateTicketRequest {
    private Vehicle vehicle;
}
