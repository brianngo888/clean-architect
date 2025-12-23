package com.ngocnq2.highthroughput.adapter.in.web;


import com.ngocnq2.highthroughput.application.dto.LoadResponse;
import com.ngocnq2.highthroughput.application.usecase.CpuLoadUseCase;
import com.ngocnq2.highthroughput.application.usecase.PingUseCase;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * HTTP adapter.
 * Responsibilities:
 * - HTTP mapping
 * - Delegation to use cases
 * - NO business logic
 */
@RestController
@RequestMapping("/api/v1/load")
public class LoadController {

  private final PingUseCase pingUseCase;
  private final CpuLoadUseCase cpuLoadUseCase;

  public LoadController(
      PingUseCase pingUseCase,
      CpuLoadUseCase cpuLoadUseCase) {
    this.pingUseCase = pingUseCase;
    this.cpuLoadUseCase = cpuLoadUseCase;
  }

  @GetMapping("/ping")
  public Mono<LoadResponse> ping() {
    return pingUseCase.execute()
        .map(r -> new LoadResponse(r.value()));
  }

  @GetMapping("/cpu")
  public Mono<LoadResponse> cpu() {
    return cpuLoadUseCase.execute()
        .map(r -> new LoadResponse(r.value()));
  }
}