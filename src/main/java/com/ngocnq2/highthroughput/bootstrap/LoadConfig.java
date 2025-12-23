package com.ngocnq2.highthroughput.bootstrap;

import com.ngocnq2.highthroughput.application.usecase.PingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Manual wiring keeps architecture explicit.
 */
@Configuration
public class LoadConfig {

  @Bean
  main.java.com.ngocnq2.highthroughput.application.usecase.PingUseCase pingUseCase() {
    return new PingUseCase();
  }

  @Bean
  CpuLoadUseCase cpuLoadUseCase() {
    return new CpuLoadUseCase();
  }
}