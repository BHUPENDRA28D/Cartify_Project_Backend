package com.cartify.utils;

import java.util.Set;

public class DummyPaymentGateway {
    private static final Set<String> VALID_CARDS = Set.of(
            "1111222233334444",
            "5555666677778888",
            "9999000011112222",
            "1234567812345678",
            "8765432187654321"
    );

    private static final Set<String> VALID_UPI = Set.of(
            "test@upi",
            "demo@upi",
            "cartify@upi",
            "customer@upi",
            "pay@upi"
    );

    public static boolean processCard(String cardNumber) {
        return VALID_CARDS.contains(cardNumber);
    }

    public static boolean processUpi(String upi) {
        return VALID_UPI.contains(upi);
    }
}
