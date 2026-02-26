package com.cartify.service.customer.Implementation;

import com.cartify.dto.request.PaymentRequest;
import com.cartify.dto.response.PaymentResponse;
import com.cartify.model.entities.Invoice;
import com.cartify.model.entities.Order;
import com.cartify.model.entities.Payment;
import com.cartify.model.enums.OrderStatus;
import com.cartify.model.enums.PaymentMode;
import com.cartify.repository.InvoiceRepository;
import com.cartify.repository.OrderRepository;
import com.cartify.repository.PaymentRepository;
import com.cartify.service.customer.PaymentService;
import com.cartify.utils.DummyPaymentGateway;
import com.cartify.utils.InvoiceGeneratorUtil; // Add this import
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Service
public class PaymentServiceImp implements PaymentService { // Changed from extends to implements

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    public PaymentServiceImp(OrderRepository orderRepository,
                             PaymentRepository paymentRepository,
                             InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest, Long customerId) {
        java.util.Optional<Order> orderOptional = orderRepository.findById(paymentRequest.getOrderId());
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order not found");
        }
        Order order = orderOptional.get();

        // 4.1 Validate Order
        if (!order.getCustomer().getId().equals(customerId)) {
            throw new RuntimeException("Unauthorized payment attempt");
        }

        if (order.getStatus() == OrderStatus.CANCELLED) {
            throw new RuntimeException("Cannot pay cancelled order");
        }

        if (order.getStatus() == OrderStatus.CONFIRMED) {
            throw new RuntimeException("Order already paid");
        }

        // Rest of the method remains the same...
        boolean paymentSuccess = false;

        if (paymentRequest.getPaymentMode() == PaymentMode.CREDIT_CARD ||
                paymentRequest.getPaymentMode() == PaymentMode.DEBIT_CARD) {
            paymentSuccess = DummyPaymentGateway.processCard(paymentRequest.getCardNumber());
        } else if (paymentRequest.getPaymentMode() == PaymentMode.UPI) {
            paymentSuccess = DummyPaymentGateway.processUpi(paymentRequest.getUpiId());
        }

        if (!paymentSuccess) {
            throw new RuntimeException("Payment failed - invalid dummy data");
        }

        String transactionId = UUID.randomUUID().toString();

        Payment payment = new Payment();
        payment.setPaymentMode(paymentRequest.getPaymentMode());
        payment.setTransactionId(transactionId);
        payment.setAmount(order.getTotalAmount());
        payment.setTimestamp(LocalDateTime.now());
        payment.setOrder(order);
        payment.setSuccess(true);

        paymentRepository.save(payment);

        order.setStatus(OrderStatus.CONFIRMED);
        orderRepository.save(order);

        String invoiceNumber = "INV-" + System.currentTimeMillis();

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(invoiceNumber);
        invoice.setTransactionId(transactionId);
        invoice.setTotalAmount(order.getTotalAmount());
        invoice.setCreatedAt(LocalDateTime.now());
        invoice.setOrder(order);

        invoiceRepository.save(invoice);

        PaymentResponse response = new PaymentResponse();
        response.setMessage("Payment Successful");
        response.setTransactionId(transactionId);
        response.setInvoiceNumber(invoiceNumber);
        response.setOrderId(order.getId());

        return response;
    }

    @Override
    public byte[] download(Long orderId, Long customerId) {

        java.util.Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order not found");
        }
        Order order = orderOptional.get();

        if (!order.getCustomer().getId().equals(customerId)) {
            throw new RuntimeException("Unauthorized");
        }

        Optional<Invoice> invoiceOptional = invoiceRepository.findByOrderId(orderId);

        if (!invoiceOptional.isPresent()) {
            throw new RuntimeException("Invoice not found");
        }
        Invoice invoice = invoiceOptional.get();

        return InvoiceGeneratorUtil.generateInvoicePdf(invoice);
    }
}
