package com.ngocnq2.payment.domain.ports;

import com.ngocnq2.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PaymentRepositoryPort {
  Mono<Payment> save(Payment payment);
  Mono<Payment> findById(UUID id);
}
