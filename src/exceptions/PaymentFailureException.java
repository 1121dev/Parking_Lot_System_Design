package exceptions;

public class PaymentFailureException extends RuntimeException{
    public PaymentFailureException()
    {
        super("Payment Failed--Please try again");
    }
}
