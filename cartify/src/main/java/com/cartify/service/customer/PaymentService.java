
package com.cartify.service.customer;

import com.cartify.dto.request.PaymentRequest;
import com.cartify.dto.response.PaymentResponse;

public interface PaymentService {


    PaymentResponse makePayment(PaymentRequest paymentRequest, Long customerId);

    byte[] download(Long orderId, Long customerId);
}
