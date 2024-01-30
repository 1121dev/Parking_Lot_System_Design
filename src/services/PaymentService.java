package services;

import Gateway.PaymentGateway;
import ThirdParty.PaymentAPI;
import exceptions.PaymentFailureException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.ExitTicket;
import models.Invoice;
import models.ParkingLot;
import models.Payment;

@Getter
@Setter
@Builder
public class PaymentService {
//    private int paymentType;
//    private String bankName;
    private ParkingLot parkingLot;
    private ExitTicket exitTicket;
//    private double amount;
    public Invoice initiateTransaction(int paymentType, String bankName, double amount)
    {   PaymentGateway paymentGateway = new PaymentGateway();
        PaymentAPI clientAPI = paymentGateway.requestAPI(bankName,paymentGateway);
        Payment payment = null;
        if(paymentType==1)
            payment = clientAPI.DebitCardTransaction(amount);
        else if(paymentType==2)
            payment = clientAPI.CreditCardTransaction(amount);
        else
            payment = clientAPI.UPITransaction(amount);
        payment.setTicket(exitTicket.getTicket());
        if(payment.getStatus().equals("Not Successful"))
            throw new PaymentFailureException();
        Invoice invoice = Invoice.builder().transactionId(payment.getTransactionId()).paymentStatus(payment.getStatus()).transactionMode(payment.getPaymentMode()).entryTime(payment.getTicket().getEntryTime()).exitTime(this.exitTicket.getExitTime()).build();
        if(invoice==null)
            throw new PaymentFailureException();
        this.parkingLot.getPaymentRepository().savePayment(invoice,this.exitTicket);
        return invoice;
    }
}
