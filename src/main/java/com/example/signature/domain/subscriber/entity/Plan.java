package com.example.signature.domain.subscriber.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Plan {
  private final UUID id;

  @Setter
  private String publicName;
  @Setter
  private String privateName;
  @Setter
  private double price;

  private int orderFeePercentage;

  public Plan(
          UUID id,
          String publicName,
          double price,
          int orderFeePercentage
  ) {
    this.id = id;
    this.publicName = publicName;
    this.privateName = publicName;
    this.price = price;
    this.orderFeePercentage = orderFeePercentage;
  }

  public Plan(
          UUID id,
          String publicName,
          String privateName,
          double price,
          int orderFeePercentage
  ) {
    this.id = id;
    this.publicName = publicName;
    this.privateName = privateName;
    this.price = price;
    this.orderFeePercentage = orderFeePercentage;
  }

  public void setOrderFeePercentage(int orderFeePercentage) {
    if (orderFeePercentage < 0) throw new RuntimeException("tbd");
    if (orderFeePercentage > 100) throw new RuntimeException("tbd");

    this.orderFeePercentage = orderFeePercentage;
  }
}
