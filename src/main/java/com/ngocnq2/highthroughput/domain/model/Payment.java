package com.ngocnq2.payment.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public final class Payment {
  private final UUID id;
  private final String customerId;
  private final BigDecimal amount;
  private final Instant createdAt;

  public Payment(UUID id, String customerId, BigDecimal amount, Instant createdAt) {
    this.id = Objects.requireNonNull(id);
    this.customerId = Objects.requireNonNull(customerId);
    this.amount = Objects.requireNonNull(amount);
    this.createdAt = Objects.requireNonNull(createdAt);
    if (amount.signum() <= 0) throw new IllegalArgumentException("amount must be > 0");
  }

  public UUID id() { return id; }
  public String customerId() { return customerId; }
  public BigDecimal amount() { return amount; }
  public Instant createdAt() { return createdAt; }
}
