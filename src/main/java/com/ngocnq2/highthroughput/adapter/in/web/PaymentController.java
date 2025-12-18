package com.ngocnq2.payment.adapter.in.web;

import com.example.payment.application.usecase.CreatePaymentUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
  private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
  private final CreatePaymentUseCase createUseCase;

  public PaymentController(CreatePaymentUseCase createUseCase) {
    this.createUseCase = createUseCase;
  }

  @PostMapping
  public Mono<PaymentResponse> create(@Valid @RequestBody CreatePaymentRequest req) {
    // log nhẹ, không log payload nhạy cảm
    log.info("Create payment for customerId={}", req.customerId());
    return createUseCase.execute(req.customerId(), req.amount())
      .map(p -> new PaymentResponse(p.id(), p.customerId(), p.amount(), p.createdAt()));
  }

  @GetMapping("/{id}")
  public Mono<PaymentResponse> get(@PathVariable UUID id) {
    // demo: query sẽ đưa vào 1 usecase riêng trong thực tế
    return Mono.error(new UnsupportedOperationException("Implement GetPaymentUseCase"));
  }
}
