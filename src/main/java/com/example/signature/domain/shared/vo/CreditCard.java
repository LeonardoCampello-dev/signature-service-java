package com.example.signature.domain.shared.vo;

import com.example.signature.domain.shared.enumaration.PaymentMethodType;
import lombok.Getter;

@Getter
public class CreditCard extends PaymentMethod {
  private final String flag;
  private final String finalFourDigits;
  private final String cvv;

  public CreditCard(
          String flag,
          String finalFourDigits,
          String cvv
  ) {
    super(PaymentMethodType.CREDIT_CARD);

    this.flag = flag;

    if (finalFourDigits.length() > 4)
      throw new RuntimeException("the final digits must be only four");

    this.finalFourDigits = finalFourDigits;
    this.cvv = cvv;
  }
}
