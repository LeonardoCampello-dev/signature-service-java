package com.example.signature.domain.invoice.entity;

import com.example.signature.domain.invoice.enumaration.InvoiceStatus;
import com.example.signature.domain.invoice.vo.Additional;
import com.example.signature.domain.invoice.vo.Discounts;
import com.example.signature.domain.invoice.vo.Fees;
import com.example.signature.domain.shared.vo.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Invoice {
  private final UUID id;
  private final Integer sequentialId;
  private final BigDecimal contractPrice;
  private final List<Additional> additions = new ArrayList<>();
  private InvoiceStatus status = InvoiceStatus.PENDING;
  private Fees fees;
  private Discounts discounts;

  private PaymentMethod paymentMethod;
  private LocalDateTime paidAt;

  public Invoice(
      UUID id,
      Integer sequentialId,
      BigDecimal contractPrice
  ) {
    this.id = id;
    this.sequentialId = sequentialId;
    this.contractPrice = contractPrice;
  }

  public void addAdditional(Additional additional) {
    this.additions.add(additional);
  }

  public Boolean isError() {
    return this.status.equals(InvoiceStatus.ERROR);
  }

  public Boolean isPaid() {
    return this.status.equals(InvoiceStatus.PAID);
  }

  public void toErrorStatus() {
    if (this.isError()) return;
    if (this.isPaid())
      throw new RuntimeException("paid status cannot be changed");

    this.status = InvoiceStatus.ERROR;
  }

  public void toPaidStatus(PaymentMethod paymentMethod) {
    if (this.isPaid())
      throw new RuntimeException("invoice has already been paid");

    if (paymentMethod == null) {
      throw new RuntimeException("payment method must be provided for paid invoice");
    }

    this.paymentMethod = paymentMethod;
    this.status = InvoiceStatus.PAID;
    this.paidAt = LocalDateTime.now();
  }
}
