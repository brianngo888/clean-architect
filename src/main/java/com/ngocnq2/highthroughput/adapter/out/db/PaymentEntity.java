
package com.ngocnq2.highthroughput.adapter.out.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Table("payments")
public record PaymentEntity(
  @Id UUID id,
  String customerId,
  BigDecimal amount,
  Instant createdAt
) {}
