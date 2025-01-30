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
public class History {

    private EEventSource source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;

}
