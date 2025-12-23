package com.ngocnq2.highthroughput.adapter.out.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

interface SpringDataPaymentRepository extends ReactiveCrudRepository<PaymentEntity, UUID> {}
