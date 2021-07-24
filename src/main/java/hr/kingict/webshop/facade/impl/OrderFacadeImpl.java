package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.OrderDto;
import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.facade.OrderFacade;
import hr.kingict.webshop.form.OrderForm;
import hr.kingict.webshop.service.DiscountCodeService;
import hr.kingict.webshop.service.OrderService;
import hr.kingict.webshop.service.PaymentMethodService;
import hr.kingict.webshop.validator.OrderFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderFacadeImpl implements OrderFacade {
    private final OrderService orderService;
    private final PaymentMethodService paymentMethodService;
    private final DiscountCodeService discountCodeService;
    private final OrderFormValidator orderFormValidator;

    public OrderFacadeImpl(OrderService orderService, PaymentMethodService paymentMethodService,
                           DiscountCodeService discountCodeService, OrderFormValidator orderFormValidator) {
        this.orderService = orderService;
        this.paymentMethodService = paymentMethodService;
        this.discountCodeService = discountCodeService;
        this.orderFormValidator = orderFormValidator;
    }

    @Override
    public void create(OrderForm orderForm) {
        orderFormValidator.validateCreate(orderForm);

        Order order = new Order();
//        BeanUtils.copyProperties(orderForm, order);
        order.setEmail(orderForm.getEmail());
        order.setDate(orderForm.getDate());
        order.setPhoneNumber(orderForm.getPhoneNumber());
        order.setTotalPriceWithoutDiscount(orderForm.getTotalPriceWithoutDiscount());
        order.setCardNumber(orderForm.getCardNumber());
        order.setDeliveryAddress(orderForm.getDeliveryAddress());
        order.setRemark(orderForm.getRemark());
        order.setPaymentMethod(paymentMethodService.get(orderForm.getPaymentMethodId()));

        if (Objects.nonNull(orderForm.getDiscountCodeId())) {
            order.setDiscountCode(discountCodeService.get(orderForm.getDiscountCodeId()));
            Float discountPrice = orderForm.getTotalPriceWithoutDiscount() - orderForm.getTotalPriceWithoutDiscount() *
                            (discountCodeService.get(orderForm.getDiscountCodeId()).getDiscount() * 0.01f);
            order.setTotalPriceWithDiscount(discountPrice);
        }
        else
            order.setTotalPriceWithDiscount(orderForm.getTotalPriceWithoutDiscount());

        orderService.save(order);
    }

    @Override
    public OrderDto get(Long id) {
        return Optional.of(orderService.get(id)).map(order -> {
            OrderDto dto = new OrderDto();
            mapOrderToDto(order, dto);

            return dto;
        }).orElse(null);
    }

    @Override
    public List<OrderDto> getAll() {
        return orderService.getAll().stream().map(order -> {
            OrderDto dto = new OrderDto();
            mapOrderToDto(order, dto);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        orderService.delete(orderService.get(id));
    }

    private void mapOrderToDto(Order order, OrderDto dto) {
        dto.setDate(order.getDate());
        dto.setCardNumber(order.getCardNumber());
        dto.setDeliveryAddress(order.getDeliveryAddress());
        dto.setEmail(order.getEmail());
        dto.setRemark(order.getRemark());
        dto.setPhoneNumber(order.getPhoneNumber());
        dto.setTotalPriceWithDiscount(order.getTotalPriceWithDiscount());
        dto.setTotalPriceWithoutDiscount(order.getTotalPriceWithoutDiscount());
        dto.setDiscountCodeId(order.getDiscountCode().getId());
        dto.setPaymentMethodId(order.getPaymentMethod().getId());
    }
}
