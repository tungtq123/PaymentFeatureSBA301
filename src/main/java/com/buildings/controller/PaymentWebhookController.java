package com.buildings.controller;

import com.buildings.dto.request.payment.PayOSWebhookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentWebhookController {

    @PostMapping("/payos-webhook")
    public ResponseEntity<?> handleWebhook(@RequestBody PayOSWebhookRequest request) {

        System.out.println("===== PAYMENT SUCCESS =====");
        System.out.println("OrderCode: " + request.getData().getOrderCode());
        System.out.println("Amount: " + request.getData().getAmount());
        System.out.println("Description: " + request.getData().getDescription());

        return ResponseEntity.ok().build();
    }

}
