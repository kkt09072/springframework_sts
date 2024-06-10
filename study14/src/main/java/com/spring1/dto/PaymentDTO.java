package com.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String paymentId;
    private String userId;
    private double amount;
    private String status;
    private String impUid;
    private String merchantUid;
    private String createdAt;
    private String updatedAt;
}
