package com.example.signature.domain.shared.vo;

import com.example.signature.domain.shared.enumaration.PaymentMethodType;

public class BankSlip extends PaymentMethod {

  public BankSlip() {
    super(PaymentMethodType.BANK_SLIP);
  }
}
