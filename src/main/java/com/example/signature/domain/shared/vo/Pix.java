package com.example.signature.domain.shared.vo;

import com.example.signature.domain.shared.enumaration.PaymentMethodType;

public class Pix extends PaymentMethod {

  public Pix() {
    super(PaymentMethodType.PIX);
  }
}
