package ThirdParty;

import Gateway.PaymentGateway;
import models.Payment;

import java.util.Random;

public class AxisBankAPIClient extends PaymentGateway implements PaymentAPI{
    private PaymentGateway paymentGateway;
    public AxisBankAPIClient(PaymentGateway paymentGateway)
    {   this.paymentGateway = paymentGateway;
        this.paymentGateway.getPayment().setBankName("AXIS");
    }
    public Payment UPITransaction(double amount)
    {
        this.getPayment().setAmount(amount);
        this.getPayment().setTransactionId(generateTractionId());
        this.getPayment().setPaymentMode("UPItransaction");
        this.getPayment().setStatus("Payment Successful");
        return this.getPayment();
    }
    public Payment DebitCardTransaction(double amount)
    {
        this.getPayment().setAmount(amount);
        this.getPayment().setTransactionId(generateTractionId());
        this.getPayment().setPaymentMode("DebitCardTransaction");
        this.getPayment().setStatus("Payment Successful");
        return this.getPayment();
    }

    public Payment CreditCardTransaction(double amount)
    {
        this.getPayment().setAmount(amount);
        this.getPayment().setTransactionId(generateTractionId());
        this.getPayment().setPaymentMode("CreditCardTransaction");
        this.getPayment().setStatus("Payment Successful");
        return this.getPayment();
    }
    public String generateTractionId()
    {
        String transactionId = "";
        Random random = new Random();
        Integer num = random.nextInt(1000)+1;
        transactionId = String.valueOf(num);
        transactionId+="AXIS";
        return transactionId;
    }

}
