package com.example.signature.domain.shared.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@ToString
public class Address {
  private final String street;
  private final String number;
  private String complement;
  private final String neighborhood;
  private final String city;
  private final String state;
  private final String zipCode;

  public Address(
          String street,
          String number,
          String neighborhood,
          String city,
          String state,
          String zipCode,
          Optional<String> complement
  ) {
    if (zipCode.length() < 8)
      throw new RuntimeException("zip code must contain eight digits");

    this.street = street;
    this.number = number;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;

    complement.ifPresent(s -> this.complement = s);
  }
}
