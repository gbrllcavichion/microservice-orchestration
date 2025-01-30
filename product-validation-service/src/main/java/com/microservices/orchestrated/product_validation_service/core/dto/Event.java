package com.microservices.orchestrated.product_validation_service.core.dto;

import java.time.LocalDateTime;

import com.microservices.orchestrated.product_validation_service.core.enums.ESagaStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private String id;
    private String transactionId;
    private String orderId;
    private Order payload;
    private String source;
    private ESagaStatus status;
    private LocalDateTime createdAt;

}
