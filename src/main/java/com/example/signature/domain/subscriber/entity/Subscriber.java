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
  private Address address;

  public Subscriber(
          UUID id,
          String name
  ) {
    this.id = id;
    this.name = name;

  }
}
