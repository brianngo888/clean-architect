package com.ngocnq2.highthroughput.domain.port;

import com.ngocnq2.highthroughput.domain.model.Payment;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PaymentRepositoryPort {
  Mono<Payment> save(Payment payment);
  Mono<Payment> findById(UUID id);
}
