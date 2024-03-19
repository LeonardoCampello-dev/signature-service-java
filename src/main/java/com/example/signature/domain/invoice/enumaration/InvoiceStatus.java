package com.example.signature.domain.invoice.enumaration;

import lombok.Getter;

@Getter
public enum InvoiceStatus {
  PENDING("Pending"), PAID("Paid"), OPEN("Open"), ERROR("Error");

  private final String status;

  InvoiceStatus(String status) {
    this.status = status;
  }
}
