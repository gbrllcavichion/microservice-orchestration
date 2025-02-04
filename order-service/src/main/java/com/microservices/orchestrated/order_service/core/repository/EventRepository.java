package com.microservices.orchestrated.order_service.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.orchestrated.order_service.core.document.Event;

public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findAllByOrderByCreatedAtDesc();

    Optional<Event> findTop1ByOrderIdOrderByCreatedAtDesc(String orderId);

    Optional<Event> findTop1ByTransactionIdOrderByCreatedAtDesc(String transactionId);

}
