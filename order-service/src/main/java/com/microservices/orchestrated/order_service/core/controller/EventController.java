package com.microservices.orchestrated.order_service.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.orchestrated.order_service.core.document.Event;
import com.microservices.orchestrated.order_service.core.dto.EventFilters;
import com.microservices.orchestrated.order_service.core.service.EventService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/event")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public Event findByFilters(EventFilters eventFilters) {
        return eventService.findByFilters(eventFilters);

    }

    @GetMapping("all")
    public List<Event> findAll() {
        return eventService.findAll();
    }

}
