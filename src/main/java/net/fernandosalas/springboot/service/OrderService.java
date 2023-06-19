package net.fernandosalas.springboot.service;

import net.fernandosalas.springboot.dto.OrderRequest;
import net.fernandosalas.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
