package com.spring.cloud.circuit.breaker.service;

import com.spring.cloud.circuit.breaker.config.ReviewFeignClient;
import com.spring.cloud.circuit.breaker.dto.ProductDto;
import com.spring.cloud.circuit.breaker.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ReviewFeignClient reviewFeignClient;

    public ProductServiceImpl(ProductRepository productRepository, ReviewFeignClient reviewFeignClient) {
        this.productRepository = productRepository;
        this.reviewFeignClient = reviewFeignClient;
    }

    @Override
    public CompletableFuture<ProductDto> getProduct(int productId) {
        var product = CompletableFuture.supplyAsync(() ->
                productRepository.findById(productId));
        var rating = CompletableFuture.supplyAsync(() ->this.reviewFeignClient.getReview(productId));
        return product.thenCombine(rating, (p, r) -> new ProductDto(productId, p.get().getDescription(), p.get().getPrice(), r));
    }
}
