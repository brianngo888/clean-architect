# clean-architect
clean-architect

ngocnq2-Dec-18-2025

=============Target System==============
- 50k CCU,
- microservices
- resilience
- fraut tolerance
- realiability
- scalle out
- zero down time
- ci/cd

==============Clean Architecture=================


PaymentController
        ↓
CreatePaymentUseCase
        ↓
PaymentRepositoryPort  ←──── implemented by ──── PaymentRepositoryAdapter
        ↓
      Domain



==============Request flow=================
[Client]
   ↓
[CDN]
   ↓
[API Gateway / Ingress]
   ↓
[Service Mesh (Istio)]
   ↓
[Microservices (Stateless)]
   ↓
[Async Backbone: Kafka / RabbitMQ]
   ↓
[DB Cluster / Cache]


==============Characteristics==============
Microservice Design Rules (KHÔNG CÃI)
✅ Stateless Service

Không lưu session trong memory

Mọi state → Redis / DB / Event Store

✅ Idempotent API

POST phải có Idempotency-Key

Retry không tạo duplicate

✅ Bounded Context

1 service = 1 business capability

Không share DB


==============3 Scale-Out Strategy (50k CCU)==============
3.1 Horizontal Scaling
HPA (CPU + RPS + Queue length)

Layer	Scale bằng
API	Pod autoscale
Worker	Queue depth
Cache	Shard
DB	Read replica
3.2 Non-Blocking Stack (BẮT BUỘC)
Layer	Tech
API	Spring WebFlux
IO	Netty
DB	R2DBC
Client	WebClient
Messaging	Reactive consumer

👉 Thread-per-request = chết ở 50k CCU

==============4 Resilience Patterns==============
Pattern	Dùng khi nào
Timeout	Chặn treo thread
Retry	Lỗi transient
Circuit Breaker	Downstream chết
Bulkhead	Cô lập failure
Fallback	Degrade gracefully


==============5 Fault Tolerance==============
Problem	           Solution
Service crash	   Stateless + restart
DB overload	       Cache + CQRS
Message mất	       At-least-once
Partial failure	   Saga

5.1 Service A → Event → Service B
     ↘ rollback ↙

==============6 Reliability (99.99%)==============
Health Check (K8s)
/actuator/health/liveness
/actuator/health/readiness

Kill pod ≠ downtime
    - Rolling update

    - Traffic draining

==============7 Zero-Downtime Deployment==============
Deployment Strategy
Strategy		   Khi dùng
Rolling	           Default
Canary		       Risky release
Blue-Green	       DB change lớn

==============8 Observability==============
8.1 Logs
{
  "traceId": "...",
  "spanId": "...",
  "service": "payment-service",
  "level": "ERROR",
  "msg": "DB timeout"
}

8.2 Metrics
Metric          Ý nghĩa
RPS             Load
p95      	    Latency
Error rate 	    Reliability
Queue lag	    Backpressure

8.3 Tracing
Client → Gateway → Service A → Kafka → Service B → DB

👉 Debug 1 request xuyên hệ thống

==============9 CI/CD Pipeline==============
Commit
 ↓
Unit Test
 ↓
Integration Test
 ↓
Security Scan
 ↓
Docker Build
 ↓
Canary Deploy
 ↓
Auto Rollback

9.1 Mandatory Checks
SAST (Code)

Dependency scan

Image scan

Contract test

==============10 Non-Negotiable Tech Stack==============
Layer       	Tech
Runtime     	Java 21
API	            Spring WebFlux
Mesh	        Istio
Queue	        Kafka
Cache	        Redis
DB	            Postgres
Deploy	        Kubernetes
CI/CD	        GitHub Actions + ArgoCD
Observe	        Prometheus + Grafana + Tempo



====> Conclusion

❌ Monolith + blocking IO + thiếu observability
= KHÔNG BAO GIỜ ĐẠT 50k CCU

✅ Stateless + reactive + autoscale + canary + trace
= SYSTEM SỐNG ĐƯỢC TRONG SỰ CỐ

50k CCU · Spring WebFlux · K8s · HPA · Zero-Downtime · Canary · CI/CD


Checklist 1% WORLD-CLASS
Tiêu chí	Đạt
50k CCU	✅
Non-blocking	✅
Clean Architecture	✅
Testable	✅
Scale-out	✅
Zero-downtime	✅
CI/CD ready	✅