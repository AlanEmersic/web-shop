package hr.kingict.webshop.validator.impl;

import hr.kingict.webshop.form.OrderForm;
import hr.kingict.webshop.service.OrderService;
import hr.kingict.webshop.validator.OrderFormValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderFormValidatorImpl implements OrderFormValidator {
    private final OrderService orderService;

    public OrderFormValidatorImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void validateCreate(OrderForm form) {
        if (Objects.isNull(form.getPaymentMethodId()) || (form.getPaymentMethodId() == 1 && form.getCardNumber().isEmpty())) {
            throw new RuntimeException("validate ex for order form");
        }
    }
}
