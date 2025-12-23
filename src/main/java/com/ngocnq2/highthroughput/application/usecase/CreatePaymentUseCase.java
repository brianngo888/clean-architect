package com.ngocnq2.highthroughput.application.usecase;

import com.ngocnq2.highthroughput.domain.model.Payment;
import com.ngocnq2.highthroughput.domain.port.PaymentRepositoryPort;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.util.UUID;

public final class CreatePaymentUseCase {
  private final PaymentRepositoryPort repo;
  private final Clock clock;

  public CreatePaymentUseCase(PaymentRepositoryPort repo, Clock clock) {
    this.repo = repo;
    this.clock = clock;
  }

  public Mono<Payment> execute(String customerId, BigDecimal amount) {
    Payment p = new Payment(UUID.randomUUID(), customerId, amount, Instant.now(clock));
    return repo.save(p);
  }
}
