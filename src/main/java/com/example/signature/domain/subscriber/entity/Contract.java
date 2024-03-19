package com.example.signature.domain.subscriber.entity;

import com.example.signature.domain.subscriber.enumeration.ContractType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Contract {
  private ContractType type = ContractType.TRIAL;
  private Plan plan;
  private LocalDateTime expiresAt;
}
