package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class Invoice {
    private String transactionId;
    private String transactionMode;
    private String paymentStatus;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}
