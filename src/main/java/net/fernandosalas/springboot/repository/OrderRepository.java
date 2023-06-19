package net.fernandosalas.springboot.repository;
import net.fernandosalas.springboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
