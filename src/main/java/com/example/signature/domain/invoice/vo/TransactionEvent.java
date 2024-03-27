package com.example.signature.domain.invoice.vo;

import com.example.signature.domain.invoice.enumaration.TransactionStatus;
import com.example.signature.domain.shared.vo.PaymentMethod;
import lombok.Getter;

import java.time.LocalDateTime;

public record TransactionEvent(
    String description,
    LocalDateTime date,
    TransactionStatus status,
    PaymentMethod paymentMethod
) {
}
