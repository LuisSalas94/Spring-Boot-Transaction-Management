package net.fernandosalas.springboot.repository;
import net.fernandosalas.springboot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
