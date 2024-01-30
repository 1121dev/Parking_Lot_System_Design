package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Payment {
    private String transactionId;
    private Ticket ticket;
    private double amount;
    private String status;
    private String bankName;
    private String paymentMode;
}
