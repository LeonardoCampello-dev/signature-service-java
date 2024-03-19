package com.example.signature.domain.invoice.enumaration;

import lombok.Getter;

@Getter
public enum TransactionStatus {
  PENDING("Pending"), SUCCESS("Success"), ERROR("Error");

  private final String status;

  TransactionStatus(String status) {
    this.status = status;
  }
}
