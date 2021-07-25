package hr.kingict.webshop.service.impl;

import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.repository.OrderRepository;
import hr.kingict.webshop.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("order doesn't exist"));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
