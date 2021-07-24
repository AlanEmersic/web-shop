package hr.kingict.webshop.validator.impl;

import hr.kingict.webshop.entity.PaymentMethod;
import hr.kingict.webshop.form.PaymentMethodForm;
import hr.kingict.webshop.service.PaymentMethodService;
import hr.kingict.webshop.validator.PaymentMethodFormValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentMethodFormValidatorImpl implements PaymentMethodFormValidator {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodFormValidatorImpl(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @Override
    public void validateCreate(PaymentMethodForm form) {
        List<PaymentMethod> paymentMethods = paymentMethodService.get(form.getName().toLowerCase());

        if (form.getName().trim().isEmpty() || !paymentMethods.isEmpty()) {
            throw new RuntimeException("validate ex for payment method form");
        }
    }
}
