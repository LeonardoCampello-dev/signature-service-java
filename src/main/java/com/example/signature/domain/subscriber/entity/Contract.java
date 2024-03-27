package com.example.signature.domain.subscriber.entity;

import com.example.signature.domain.subscriber.enumeration.ContractType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Contract {
  private ContractType type;
  private Plan plan;

  private LocalDateTime expiresAt;
  private LocalDateTime acceptanceDate;

  public Contract(
          ContractType type,
          LocalDateTime expiresAt,
          LocalDateTime acceptanceDate
  ) {
    this.type = type;
    this.expiresAt = expiresAt;
    this.acceptanceDate = acceptanceDate;
  }

  public boolean isTrial() {
    return this.type.equals(ContractType.TRIAL);
  }

  public static Contract buildTrial() {
    LocalDateTime fifteenDaysLater = LocalDateTime.now().plusDays(15);

    return new Contract(
            ContractType.TRIAL,
            fifteenDaysLater,
            LocalDateTime.now()
    );
  }
}
