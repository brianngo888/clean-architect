package com.ngocnq2.payment.adapter.out.db;

import com.ngocnq2.payment.domain.model.Payment;
import com.ngocnq2.payment.domain.port.PaymentRepositoryPort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class PaymentRepositoryAdapter implements PaymentRepositoryPort {
  private final SpringDataPaymentRepository repo;

  public PaymentRepositoryAdapter(SpringDataPaymentRepository repo) {
    this.repo = repo;
  }

  @Override
  public Mono<Payment> save(Payment payment) {
    return repo.save(toEntity(payment)).map(PaymentRepositoryAdapter::toDomain);
  }

  @Override
  public Mono<Payment> findById(UUID id) {
    return repo.findById(id).map(PaymentRepositoryAdapter::toDomain);
  }

  private static PaymentEntity toEntity(Payment p) {
    return new PaymentEntity(p.id(), p.customerId(), p.amount(), p.createdAt());
  }

  private static Payment toDomain(PaymentEntity e) {
    return new Payment(e.id(), e.customerId(), e.amount(), e.createdAt());
  }
}
