package com.microservices.orchestrated.order_service.core.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.orchestrated.order_service.config.exception.ValidationException;
import com.microservices.orchestrated.order_service.core.document.Event;
import com.microservices.orchestrated.order_service.core.dto.EventFilters;
import com.microservices.orchestrated.order_service.core.repository.EventRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@Slf4j
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void notifyEnding(Event event){
        event.setOrderId(event.getOrderId());
        event.setCreatedAt(LocalDateTime.now());
        save(event);
        log.info("Order {} with saga notified! TransactionId: {}", event.getOrderId(), event.getTransactionId());
    }

    public List<Event> findAll() {
        return eventRepository.findAllByOrderByCreatedAtDesc();
    }

    public Event findByFilters(EventFilters filters) {
        validateEmptyFilters(filters);
        if(!isEmpty(filters.getOrderId())) {
            return findByOrderId(filters.getOrderId());
        } else {
            return findByTransactionId(filters.getTransactionalId());
        }
    }

    private Event findByOrderId(String orderId) {
        return eventRepository
                .findTop1ByOrderIdOrderByCreatedAtDesc(orderId)
                .orElseThrow(() -> new ValidationException("Event not found by OrderID."));
    }

    private Event findByTransactionId(String transactionId) {
        return eventRepository
                .findTop1ByTransactionIdOrderByCreatedAtDesc(transactionId)
                .orElseThrow(() -> new ValidationException("Event not found by TransactionID."));
    }

    private void validateEmptyFilters(EventFilters eventFilters) {
        if (isEmpty(eventFilters.getOrderId()) && isEmpty(eventFilters.getTransactionalId())) {
            throw new ValidationException("OrderID or TransactionID must be informed");
        }
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    };
}
