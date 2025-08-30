package com.spring.cloud.circuit.breaker.config;

import com.spring.cloud.circuit.breaker.dto.ProductReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "review-service",
        url = "${review.service.url}",
        fallback = ReviewFeignClientFallback.class
)
public interface ReviewFeignClient {

    @GetMapping("products/{productId}")
    ProductReviewDto getReview(@PathVariable("productId") Integer productId);
}
