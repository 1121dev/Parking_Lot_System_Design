package repositories;

import lombok.Getter;
import lombok.Setter;
import models.ExitTicket;
import models.Invoice;
import models.Ticket;

import java.util.Map;
@Getter
@Setter
public class PaymentRepository {
    private Map<ExitTicket,Invoice> paymentsRecord;
    public void savePayment(Invoice invoice, ExitTicket exitTicket)
    {
        paymentsRecord.put(exitTicket,invoice);
    }
}
