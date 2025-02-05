package com.microservices.orchestrated.product_validation_service.core.repository;

import com.microservices.orchestrated.product_validation_service.core.model.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

    Boolean existsByOrderIdAndTransactionId(Integer orderId, Integer transactionId);
    Optional<Validation> findByOderIdAndTransactionId(Integer orderId, Integer transactionId);

}
