package main.java.com.ngocnq2.highthroughput.application.usecase;


import com.example.load.domain.LoadResult;
import reactor.core.publisher.Mono;

/**
 * Use case for health / ping check.
 * Contains business intent, not HTTP logic.
 */
public class PingUseCase {

  public Mono<LoadResult> execute() {
    // Constant response, zero allocation, non-blocking
    return Mono.just(new LoadResult("OK"));
  }
}