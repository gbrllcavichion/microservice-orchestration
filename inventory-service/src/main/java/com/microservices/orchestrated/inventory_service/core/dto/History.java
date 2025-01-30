package com.microservices.orchestrated.inventory_service.core.dto;

import java.time.LocalDateTime;

import com.microservices.orchestrated.inventory_service.core.enums.ESagaStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    private String source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;

}
