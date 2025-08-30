package com.spring.cloud.circuit.breaker.repository;

import com.spring.cloud.circuit.breaker.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByProductId(Integer id);
}
