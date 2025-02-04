package com.microservices.orchestrated.order_service.core.dto;

import java.util.List;

import com.microservices.orchestrated.order_service.core.document.OrderProducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private List<OrderProducts> products;

}
