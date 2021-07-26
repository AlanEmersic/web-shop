package hr.kingict.webshop.mapper.impl;

import hr.kingict.webshop.dto.OrderDto;
import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.mapper.OrderDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderDtoMapperImpl implements OrderDtoMapper {
    @Override
    public OrderDto map(Order order) {
        if (Objects.isNull(order))
            return null;

        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setDate(order.getDate());
        dto.setCardNumber(order.getCardNumber());
        dto.setDeliveryAddress(order.getDeliveryAddress());
        dto.setEmail(order.getEmail());
        dto.setRemark(order.getRemark());
        dto.setPhoneNumber(order.getPhoneNumber());
        dto.setTotalPriceWithDiscount(order.getTotalPriceWithDiscount());
        dto.setTotalPriceWithoutDiscount(order.getTotalPriceWithoutDiscount());
        if (Objects.nonNull(order.getDiscountCode()))
            dto.setDiscountCodeId(order.getDiscountCode().getId());
        dto.setPaymentMethodId(order.getPaymentMethod().getId());

        return dto;
    }
}
