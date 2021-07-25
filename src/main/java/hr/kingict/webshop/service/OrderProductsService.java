package hr.kingict.webshop.service;

import hr.kingict.webshop.entity.OrderProducts;

import java.util.List;

public interface OrderProductsService {
    void save(OrderProducts orderProducts);

    OrderProducts get(Long id);

    List<OrderProducts> getAll();

    void delete(OrderProducts orderProducts);
}
