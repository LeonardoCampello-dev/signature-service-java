package com.example.signature.domain.shared.enumaration;

import lombok.Getter;

@Getter
public enum PaymentMethodType {
  PIX("Pix"), BANK_SLIP("Bank slip"), CREDIT_CARD("Credit card");
  private final String type;

  PaymentMethodType(String type) {
    this.type = type;
  }
}
