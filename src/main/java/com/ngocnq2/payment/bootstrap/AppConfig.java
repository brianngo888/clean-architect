package com.ngocnq2.payment.bootstrap;

import com.ngocnq2.payment.application.usecase.CreatePaymentUseCase;
import com.ngocnq2.payment.domain.ports.PaymentRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class AppConfig {
  @Bean
  Clock clock() { return Clock.systemUTC(); }

  @Bean
  CreatePaymentUseCase createPaymentUseCase(PaymentRepositoryPort repo, Clock clock) {
    return new CreatePaymentUseCase(repo, clock);
  }
}
