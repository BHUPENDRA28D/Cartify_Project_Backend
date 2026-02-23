
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
}
