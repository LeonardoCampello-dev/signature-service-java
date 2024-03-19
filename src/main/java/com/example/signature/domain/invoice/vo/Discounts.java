package com.example.signature.domain.invoice.vo;

import java.math.BigDecimal;

public record Discounts(BigDecimal bonus) {

  public BigDecimal getTotal() {
    BigDecimal total = new BigDecimal(0);

    return total.add(bonus);
  }
}
