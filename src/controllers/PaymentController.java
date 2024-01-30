package controllers;

import dto.GenerateTicketResponse;
import dto.InitiatePaymentRequest;
import dto.InitiatePaymentResponse;
import exceptions.PaymentFailureException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Invoice;
import models.Ticket;
import services.PaymentService;
@Getter
@Setter
@Builder
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;

    }
    public InitiatePaymentResponse generateTransaction(InitiatePaymentRequest request)
    {
        Invoice invoice = this.paymentService.initiateTransaction(request.getPaymentMode(),request.getBankName(), request.getAmount());
        if(invoice==null)
            throw new PaymentFailureException();
        // Rendering the response
        return InitiatePaymentResponse.builder().invoice(invoice).build();
    }
}
