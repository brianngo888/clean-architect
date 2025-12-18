package main.java.com.ngocnq2.highthroughput.bootstrap;

import com.example.load.application.usecase.CpuLoadUseCase;
import com.example.load.application.usecase.PingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Manual wiring keeps architecture explicit.
 */
@Configuration
public class LoadConfig {

  @Bean
  PingUseCase pingUseCase() {
    return new PingUseCase();
  }

  @Bean
  CpuLoadUseCase cpuLoadUseCase() {
    return new CpuLoadUseCase();
  }
}