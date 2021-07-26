package hr.kingict.webshop.mapper.impl;

import hr.kingict.webshop.dto.OrderProductsDto;
import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.entity.OrderProducts;
import hr.kingict.webshop.mapper.OrderProductsDtoMapper;
import hr.kingict.webshop.service.PaymentMethodService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class OrderProductsDtoMapperImpl implements OrderProductsDtoMapper {
    @Override
    public OrderProductsDto map(OrderProducts orderProducts) {
        if (Objects.isNull(orderProducts))
            return null;

        OrderProductsDto dto = new OrderProductsDto();
        dto.setId(orderProducts.getId());
        dto.setOrderId(orderProducts.getOrder().getId());
        dto.setProductId(orderProducts.getProduct().getId());

        return dto;
    }

    @Override
    public void orderDefaultValues(Order order, Long id, PaymentMethodService paymentMethodService) {
        order.setId(id);
        order.setDate(LocalDate.now());
        order.setTotalPriceWithoutDiscount(0f);
        order.setTotalPriceWithDiscount(0f);
        order.setPaymentMethod(paymentMethodService.get(2L));
        order.setEmail("");
        order.setPhoneNumber("0");
        order.setDeliveryAddress("");
    }
}
