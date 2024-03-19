package com.example.signature.domain.invoice.vo;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public record Fees(BigDecimal orders, BigDecimal additional) {

  public BigDecimal getTotal() {
    BigDecimal total = new BigDecimal(0);

    return total.add(orders)
                .add(additional);


  }
}
