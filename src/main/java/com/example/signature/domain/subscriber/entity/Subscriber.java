package com.example.signature.domain.subscriber.entity;

import com.example.signature.domain.shared.vo.Address;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Subscriber {
  private final UUID id;

  @Setter
  private String name;

  @Setter
  private String email;

  @Setter
  private Address address;

  private Contract contract;

  private String partnerId;

  public Subscriber(
          UUID id,
          String name,
          String email,
          Address address,
          Contract contract
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
    this.contract = contract;
  }

  public void linkPartner(String partnerId) {
    this.partnerId = partnerId;
  }
}
