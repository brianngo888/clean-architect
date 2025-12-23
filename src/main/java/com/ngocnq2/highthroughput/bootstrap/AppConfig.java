package com.ngocnq2.highthroughput.bootstrap;

import com.ngocnq2.highthroughput.application.usecase.CreatePaymentUseCase;
import com.ngocnq2.highthroughput.domain.port.PaymentRepositoryPort;
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
