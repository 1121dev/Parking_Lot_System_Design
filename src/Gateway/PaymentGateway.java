package Gateway;

import ThirdParty.AxisBankAPIClient;
import ThirdParty.ICICIBankAPIClient;
import ThirdParty.PaymentAPI;
import ThirdParty.SBIBankAPIClient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Payment;

import java.util.Objects;
import java.util.Random;

@Getter
@Setter

public class PaymentGateway {
    private Payment payment;
    public PaymentGateway()
    {

        this.payment = Payment.builder().build();
    }
    public PaymentGateway(String bankName)
    {
        this.payment = Payment.builder().bankName(bankName).build();
    }
    public PaymentAPI requestAPI(String bankName, PaymentGateway paymentGateway)
    {
        if(Objects.equals(bankName, "AXIS"))
            return new AxisBankAPIClient(paymentGateway);
        else if(Objects.equals(bankName, "SBI"))
            return new SBIBankAPIClient(paymentGateway);
        else if(Objects.equals(bankName, "ICICI"))
            return new ICICIBankAPIClient(paymentGateway);
        else
            return null;
    }


}
