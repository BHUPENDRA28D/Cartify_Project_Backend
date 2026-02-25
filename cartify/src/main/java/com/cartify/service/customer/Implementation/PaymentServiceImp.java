package com.cartify.service.customer;

import com.cartify.dto.request.PaymentRequest;
import com.cartify.dto.response.PaymentResponse;
import com.cartify.model.entities.Order;
import com.cartify.repository.InvoiceRepository;
import com.cartify.repository.OrderRepository;
import com.cartify.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentServiceImp {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;



//    @Override
////    @Transactional
////    public PaymentResponse makePayment(PaymentRequest paymentRequest, Long customerId) {
////
////        Order order = orderRepository.findById(paymentRequest.getOrder)
////    }
////
////    @Override
////    public byte[] download(Long orderId, Long customerId) {
////        return new byte[0];
////    }
}
