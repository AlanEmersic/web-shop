package hr.kingict.webshop.repository;

import hr.kingict.webshop.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    List<PaymentMethod> findByName(String name);
}
