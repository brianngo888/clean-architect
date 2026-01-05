package com.ngocnq2.highthroughput.adapter.out.http;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ExternalClient {
  private final WebClient webClient;

  public ExternalClient(WebClient.Builder builder) {
    this.webClient = builder.baseUrl("https://example.com").build();
  }

  @CircuitBreaker(name = "externalApi", fallbackMethod = "fallback")
  public Mono<String> fetchStatus() {
    return webClient.get().uri("/status")
      .retrieve()
      .bodyToMono(String.class)
      .timeout(java.time.Duration.ofMillis(500));
  }

  private Mono<String> fallback(Throwable t) {
    return Mono.just("DEGRADED");
  }
}
