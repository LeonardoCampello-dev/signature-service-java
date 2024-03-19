package com.example.signature.domain.subscriber.enumeration;

import lombok.Getter;

@Getter
public enum ContractType {
  TRIAL("Trial"), PAID("Paid");

  private final String type;

  ContractType(String type) {
    this.type = type;
  }
}
