package com.microservices.orchestrated.order_service.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventFilters {

    private String orderId;
    private String transactionalId;

}
