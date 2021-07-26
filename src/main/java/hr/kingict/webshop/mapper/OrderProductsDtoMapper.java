package hr.kingict.webshop.mapper;

import hr.kingict.webshop.dto.OrderProductsDto;
import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.entity.OrderProducts;
import hr.kingict.webshop.service.PaymentMethodService;

public interface OrderProductsDtoMapper {
    OrderProductsDto map(OrderProducts orderProducts);
    void orderDefaultValues(Order order, Long id, PaymentMethodService paymentMethodService);
}
