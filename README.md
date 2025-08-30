# spring cloud open feign circuit breaker
Feign is a declarative web service client. It makes writing web service clients easier.  To use Feign create an interface and annotate it. It has pluggable annotation support including Feign annotations and JAX-RS annotations. Feign also supports pluggable encoders and decoders

# Feign Spring Cloud CircuitBreaker Fallbacks
Spring Cloud CircuitBreaker supports the notion of a fallback: a default code path that is executed when the circuit is open or there is an error. To enable fallbacks for a given @FeignClient set the fallback attribute to the class name that implements the fallback.

In this project have 2 different module Feign client implementations
 - Non-Reactive FeignClient library
 - Reactive ReactiveFeignClient library