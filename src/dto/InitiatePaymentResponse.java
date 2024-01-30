package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Invoice;
import models.Payment;
@Getter
@Setter
@Builder
public class InitiatePaymentResponse {
    private Invoice invoice;
}
