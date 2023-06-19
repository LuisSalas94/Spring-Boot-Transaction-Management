package net.fernandosalas.springboot.controller;
import lombok.AllArgsConstructor;
import net.fernandosalas.springboot.dto.OrderRequest;
import net.fernandosalas.springboot.dto.OrderResponse;
import net.fernandosalas.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
