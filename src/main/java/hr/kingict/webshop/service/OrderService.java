package hr.kingict.webshop.service;

import hr.kingict.webshop.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    Order get(Long id);

    Order getLastOrder();

    List<Order> getAll();

    void delete(Order order);
}
