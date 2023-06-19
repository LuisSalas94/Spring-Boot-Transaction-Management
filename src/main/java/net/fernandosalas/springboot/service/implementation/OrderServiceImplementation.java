package net.fernandosalas.springboot.service.implementation;
import lombok.AllArgsConstructor;
import net.fernandosalas.springboot.dto.OrderRequest;
import net.fernandosalas.springboot.dto.OrderResponse;
import net.fernandosalas.springboot.entity.Order;
import net.fernandosalas.springboot.entity.Payment;
import net.fernandosalas.springboot.exception.PaymentException;
import net.fernandosalas.springboot.repository.OrderRepository;
import net.fernandosalas.springboot.repository.PaymentRepository;
import net.fernandosalas.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public OrderServiceImplementation(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("In Progress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("Debit")){
            throw new PaymentException("Payment card type do not supported");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(orderResponse.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Success");
        return orderResponse;
    }
}
