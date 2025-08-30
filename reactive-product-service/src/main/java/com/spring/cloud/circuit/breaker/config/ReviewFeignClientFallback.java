package com.spring.cloud.circuit.breaker.config;

import com.spring.cloud.circuit.breaker.dto.ProductReviewDto;
import com.spring.cloud.circuit.breaker.dto.ReviewDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ReviewFeignClientFallback implements ReviewFeignClient {

    @Override
    public Mono<ProductReviewDto> getReview(Integer productId) {
        // Return default or cached response
        ProductReviewDto fallbackReview = new ProductReviewDto(List.of(new ReviewDto(productId, "Fallback: Review service unavailable", 0, "")), 0);
        return Mono.justOrEmpty(fallbackReview);
    }


}
