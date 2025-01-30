package com.microservices.orchestrated.orchestrator_service.core.dto;

import java.time.LocalDateTime;

import com.microservices.orchestrated.orchestrator_service.core.enums.EEventSource;
import com.microservices.orchestrated.orchestrator_service.core.enums.ESagaStatus;

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
    private EEventSource source;
    private ESagaStatus status;
    private LocalDateTime createdAt;

}
