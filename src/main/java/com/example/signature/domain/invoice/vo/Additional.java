package com.example.signature.domain.invoice.vo;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Additional {
  private final String description;
  private final BigDecimal price;
  private String collectorId;

  public Additional(
      String description,
      BigDecimal price
  ) {
    this.description = description;
    this.price = price;
  }

  public Additional(
      String description,
      BigDecimal price,
      String collectorId
  ) {
    this.description = description;
    this.price = price;
    this.collectorId = collectorId;
  }
}
