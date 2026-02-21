package com.buildings.dto.response;

public record PaymentQRResponse(
        String qrCode,
        String checkoutUrl,
        Integer amount,
        java.util.UUID monthlyBillId,
        String periodCode
) {}
