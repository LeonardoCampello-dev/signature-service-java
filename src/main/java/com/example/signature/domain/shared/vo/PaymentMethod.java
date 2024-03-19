package com.example.signature.domain.shared.vo;

import com.example.signature.domain.shared.enumaration.PaymentMethodType;
import lombok.Getter;

@Getter
public abstract class PaymentMethod {
  private final PaymentMethodType type;

  public PaymentMethod(PaymentMethodType type) {
    this.type = type;
  }
}
