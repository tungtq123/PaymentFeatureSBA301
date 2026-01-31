package com.buildings.entity;

import com.buildings.entity.enums.BillStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "monthly_bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyBill extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    private LocalDate periodFrom;

    private LocalDate periodTo;

    @Column(length = 7)
    private String periodCode;

    @Column(precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(precision = 12, scale = 2)
    private BigDecimal taxTotal;

    @Column(precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private BillStatus status;

    private LocalDateTime issuedAt;

    private LocalDateTime dueDate;

    private Boolean locked;

    @Column(length = 500)
    private String note;

    @OneToMany(mappedBy = "monthlyBill", cascade = CascadeType.ALL)
    private List<PaymentTransaction> paymentTransactions;
}