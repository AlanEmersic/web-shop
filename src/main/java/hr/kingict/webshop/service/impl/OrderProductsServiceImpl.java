package hr.kingict.webshop.service.impl;

import hr.kingict.webshop.entity.OrderProducts;
import hr.kingict.webshop.repository.OrderProductsRepository;
import hr.kingict.webshop.service.OrderProductsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderProductsServiceImpl implements OrderProductsService {
    private final OrderProductsRepository orderProductsRepository;

    public OrderProductsServiceImpl(OrderProductsRepository orderProductsRepository) {
        this.orderProductsRepository = orderProductsRepository;
    }

    @Override
    @Transactional
    public void save(OrderProducts orderProducts) {
        orderProductsRepository.save(orderProducts);
    }

    @Override
    public OrderProducts get(Long id) {
        return orderProductsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("orderProducts doesn't exist"));
    }

    @Override
    public List<OrderProducts> getAll() {
        return orderProductsRepository.findAll();
    }

    @Override
    public void delete(OrderProducts orderProducts) {
        orderProductsRepository.delete(orderProducts);
    }
}
