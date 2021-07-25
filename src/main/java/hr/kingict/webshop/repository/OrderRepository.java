package hr.kingict.webshop.repository;

import hr.kingict.webshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findTopByOrderByIdDesc();
}
