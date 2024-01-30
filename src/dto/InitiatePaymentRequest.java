package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InitiatePaymentRequest {
    private int paymentMode;
    private String bankName;
    private double amount;
}
