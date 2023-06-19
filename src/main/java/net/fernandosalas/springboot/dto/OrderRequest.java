package net.fernandosalas.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import net.fernandosalas.springboot.entity.Order;
import net.fernandosalas.springboot.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
