package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.OrderDto;
import hr.kingict.webshop.entity.DiscountCode;
import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.facade.OrderFacade;
import hr.kingict.webshop.form.OrderForm;
import hr.kingict.webshop.service.DiscountCodeService;
import hr.kingict.webshop.service.OrderService;
import hr.kingict.webshop.service.PaymentMethodService;
import hr.kingict.webshop.validator.OrderFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

        Order order = orderService.get(1L);
        BeanUtils.copyProperties(orderForm, order);
        order.setDate(LocalDate.now());
        order.setPaymentMethod(paymentMethodService.get(orderForm.getPaymentMethodId()));
        System.out.println(paymentMethodService.get(orderForm.getPaymentMethodId()));
        if (Objects.nonNull(orderForm.getDiscountCodeId())) {
            DiscountCode discountCode = discountCodeService.get(orderForm.getDiscountCodeId());
            if (!discountCode.getUsed()) {
                discountCode.setUsed(true);
                discountCodeService.save(discountCode);

                order.setDiscountCode(discountCodeService.get(orderForm.getDiscountCodeId()));
                Float discountPrice = orderForm.getTotalPriceWithoutDiscount() - orderForm.getTotalPriceWithoutDiscount() *
                        (discountCodeService.get(orderForm.getDiscountCodeId()).getDiscount() * 0.01f);
                order.setTotalPriceWithDiscount(discountPrice);
            }
        } else
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
    }
}
