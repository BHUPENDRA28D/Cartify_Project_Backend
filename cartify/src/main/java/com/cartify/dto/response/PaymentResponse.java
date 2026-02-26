
package com.cartify.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private String message;
    private String transactionId;
    private String invoiceNumber;
    private Long orderId;


    // Default constructor (already exists)
    public PaymentResponse() {}

    // NEW: Public all-args constructor
    public PaymentResponse(String message, String transactionId, String invoiceNumber, Long orderId) {
        this.message = message;
        this.transactionId = transactionId;
        this.invoiceNumber = invoiceNumber;
        this.orderId = orderId;
    }
}
