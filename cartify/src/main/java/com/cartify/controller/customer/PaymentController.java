
package com.cartify.controller.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/customer/payment")
public class PaymentController {

    @GetMapping("/pay")
    public String payAmount(){
        return "Payment api are here.";
    }
}
