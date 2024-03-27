package com.example.signature.domain.invoice.entity;

import com.example.signature.domain.invoice.enumaration.TransactionStatus;
import com.example.signature.domain.invoice.vo.TransactionEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class TransactionHistory {
  private final UUID id;
  private final UUID invoiceId;
  private final List<TransactionEvent> events = new ArrayList<>();

  public TransactionHistory(
      UUID id,
      UUID invoiceId
  ) {
    this.id = id;
    this.invoiceId = invoiceId;
  }

  public void addEvent(TransactionEvent event) {
    this.events.add(event);
  }
}
