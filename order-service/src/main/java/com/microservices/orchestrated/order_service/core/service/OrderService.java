package com.microservices.orchestrated.order_service.core.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservices.orchestrated.order_service.core.document.Event;
import com.microservices.orchestrated.order_service.core.document.Order;
import com.microservices.orchestrated.order_service.core.dto.OrderRequest;
import com.microservices.orchestrated.order_service.core.producer.SagaProducer;
import com.microservices.orchestrated.order_service.core.repository.OrderRepository;
import com.microservices.orchestrated.order_service.core.utils.JsonUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private static final String TRANSACTION_ID_PATTERN = "%s_%s";

    private final EventService eventService;
    private final SagaProducer producer;
    private final JsonUtil jsonUtil;
    private final OrderRepository repository;

    public Order createOrder(OrderRequest orderRequest) {
        var order = Order
                .builder()
                .product(orderRequest.getProducts())
                .createdAt(LocalDateTime.now())
                .transactionId(
                    String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID())
                )
                .build();
            repository.save(order);
            producer.sendEvent(jsonUtil.toJson(createPayload(order)));
            return order;
    }

    private Event createPayload(Order order) {
        var event = Event
                .builder()
                .orderId(order.getId())
                .transactionId(order.getTransactionId())
                .payload(order)
                .createdAt(LocalDateTime.now())
                .build();
        eventService.save(event);
        return event;
    }

}
