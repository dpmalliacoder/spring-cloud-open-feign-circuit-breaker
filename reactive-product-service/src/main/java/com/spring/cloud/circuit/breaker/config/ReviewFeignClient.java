package com.spring.cloud.circuit.breaker.config;

import com.spring.cloud.circuit.breaker.dto.ProductReviewDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(
        name = "review-service",
        url = "${review.service.url}",
        fallback = ReviewFeignClientFallback.class
)
public interface ReviewFeignClient {

    @GetMapping("products/{productId}")
    Mono<ProductReviewDto> getReview(@PathVariable("productId") Integer productId);
}
