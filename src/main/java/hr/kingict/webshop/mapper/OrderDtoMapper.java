package hr.kingict.webshop.mapper;

import hr.kingict.webshop.dto.OrderDto;
import hr.kingict.webshop.entity.Order;

public interface OrderDtoMapper {
    OrderDto map(Order order);
}
