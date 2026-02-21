package com.buildings.controller;

import com.buildings.dto.response.payment.PaymentResponse;
import com.buildings.entity.Bill;
import com.buildings.service.impl.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    // Lấy chi tiết bill
    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBill(
            @PathVariable UUID billId) {
        System.out.println("Received ID: " + billId);

        return ResponseEntity.ok(
                billService.getBillDetail(billId)
        );
    }


    // Tạo payment link + trả QR
    @PostMapping("/{billId}/payment")
    public ResponseEntity<PaymentResponse> createPayment(
            @PathVariable UUID billId) throws Exception {

        return ResponseEntity.ok(
                billService.createPayment(billId)
        );
    }
}

