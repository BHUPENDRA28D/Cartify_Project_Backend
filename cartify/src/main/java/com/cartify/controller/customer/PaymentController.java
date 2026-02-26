
package com.cartify.controller.customer;

import com.cartify.dto.request.PaymentRequest;
import com.cartify.dto.response.PaymentResponse;
import com.cartify.service.customer.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;  // ← Use this instead

@RestController
@RequestMapping("/api/customer/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> pay(
            @Valid @RequestBody PaymentRequest request,
            @RequestParam Long customerId) {

        PaymentResponse response =
                paymentService.makePayment(request, customerId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/invoice/{orderId}")
    public ResponseEntity<byte[]> downloadInvoice(
            @PathVariable Long orderId,
            @RequestParam Long customerId) {

        byte[] pdf = paymentService.download(orderId, customerId);

        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=invoice.pdf")
                .body(pdf);
    }
}

/*   // only after authentication jwt genration is done.


@RestController
@RequestMapping("/api/customer/payment")
public class PaymentController {

    private final PaymentService paymentService;

    // MANUAL constructor (no Lombok)
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> pay(
            @Valid @RequestBody PaymentRequest request,
            @AuthenticationPrincipal CustomUserDetails user) {

        PaymentResponse response = paymentService.makePayment(request, user.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/invoice/{orderId}")
    public ResponseEntity<byte[]> downloadInvoice(
            @PathVariable Long orderId,
            @AuthenticationPrincipal CustomUserDetails user) {

        byte[] pdf = paymentService.download(orderId, user.getId());  // ← FIXED method name
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=invoice.pdf")
                .body(pdf);
    }
}
*/
