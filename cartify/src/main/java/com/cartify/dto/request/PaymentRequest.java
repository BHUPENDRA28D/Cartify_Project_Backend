
package com.cartify.dto.request;

import com.cartify.model.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import org.antlr.v4.runtime.misc.NotNull;
//import org.hibernate.annotations.processing.Pattern;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {




        private Long orderId;
        private PaymentMode paymentMode;
        private String cardNumber;
        private String cardHolderName;
        private String expiryDate;
        private String cvv;
        private String upiId;
    }

//    @NotNull(message = "Order Id is required")
//    private Long orderId;
//
//    @NotNull(message = "Payment mode is required")
//    private PaymentMode paymentMode;
//
//    // CREDIT CARD FIELDS
//    @Size(min = 16, max = 16, message = "Card number must be 16 digits")
//    private String cardNumber;
//
//    @Size(min = 10, message = "Card holder name must be at least 10 characters")
//    private String cardHolderName;
//
//    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{2}$",
//            message = "Expiry date must be in MM/YY format")
//    private String expiryDate;
//
//    @Pattern(regexp = "^[0-9]{4}$",
//            message = "CVV must be 4 digits")
//    private String cvv;
//
//    // UPI FIELD
//    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z]+$",
//            message = "Invalid UPI ID")
//    private String upiId;



