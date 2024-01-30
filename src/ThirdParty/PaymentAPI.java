package ThirdParty;

import models.Payment;

public interface PaymentAPI {
    public Payment UPITransaction(double amount);
    public Payment DebitCardTransaction(double amount);
    public Payment CreditCardTransaction(double amount);
}
