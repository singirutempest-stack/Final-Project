package kz.project.shop.repository;

import kz.project.shop.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//public interface PaymentRepository extends JpaRepository<Payment, Long> {
//
//    Optional<Payment> findByOrderId(Long orderId);
//}



public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
