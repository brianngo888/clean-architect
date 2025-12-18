package com.ngocnq2.payment.adapter.in.web;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PaymentResponse(UUID id, String customerId, BigDecimal amount, Instant createdAt) {}
