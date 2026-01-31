package com.buildings.entity.enums;

public enum PaymentStatus {
    PENDING_APPROVAL,   // Resident vừa upload proof
    APPROVED,           // Admin xác nhận OK
    REJECTED,           // Admin từ chối
    FAILED              // Lỗi kỹ thuật / không hợp lệ
}