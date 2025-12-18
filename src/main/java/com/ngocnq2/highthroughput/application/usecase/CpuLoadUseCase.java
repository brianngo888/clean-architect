package main.java.com.ngocnq2.highthroughput.application.usecase;

import com.example.load.domain.LoadResult;
import reactor.core.publisher.Mono;

/**
 * Use case simulating CPU-bound work.
 * IMPORTANT:
 * - No blocking IO
 * - No synchronization
 * - Pure computation
 */
public class CpuLoadUseCase {

  public Mono<LoadResult> execute() {
    return Mono.fromSupplier(() -> {
      long sum = 0;
      for (int i = 0; i < 1_000; i++) {
        sum += i;
      }
      return new LoadResult("CPU-" + sum);
    });
  }
}