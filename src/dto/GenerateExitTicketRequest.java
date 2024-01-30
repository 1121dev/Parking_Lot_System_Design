package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Builder
public class GenerateExitTicketRequest {
    private String entryTicketId;

}
