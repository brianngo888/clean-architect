package com.ngocnq2.highthroughput.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreatePaymentRequest(
  @NotBlank String customerId,
  @NotNull @Positive BigDecimal amount
) {}
