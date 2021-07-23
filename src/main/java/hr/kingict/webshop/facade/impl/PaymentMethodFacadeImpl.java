package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.PaymentMethodDto;
import hr.kingict.webshop.entity.PaymentMethod;
import hr.kingict.webshop.facade.PaymentMethodFacade;
import hr.kingict.webshop.form.PaymentMethodForm;
import hr.kingict.webshop.service.PaymentMethodService;
import hr.kingict.webshop.validator.PaymentMethodValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PaymentMethodFacadeImpl implements PaymentMethodFacade {
    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodValidator paymentMethodValidator;

    public PaymentMethodFacadeImpl(PaymentMethodService paymentMethodService, PaymentMethodValidator paymentMethodValidator) {
        this.paymentMethodService = paymentMethodService;
        this.paymentMethodValidator = paymentMethodValidator;
    }

    @Override
    public void create(PaymentMethodForm paymentMethodForm) {
        paymentMethodValidator.validateCreate(paymentMethodForm);

        PaymentMethod paymentMethod = new PaymentMethod();
        BeanUtils.copyProperties(paymentMethodForm, paymentMethod);
        paymentMethodService.save(paymentMethod);
    }

    @Override
    public PaymentMethodDto get(Long id) {
        return Optional.of(paymentMethodService.get(id)).map(paymentMethod -> {
            PaymentMethodDto dto = new PaymentMethodDto();
            dto.setName(paymentMethod.getName());

            return dto;
        }).orElse(null);
    }

    @Override
    public List<PaymentMethodDto> getAll() {
        return paymentMethodService.getAll().stream().map(paymentMethod -> {
            PaymentMethodDto dto = new PaymentMethodDto();
            dto.setName(paymentMethod.getName());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        paymentMethodService.delete(paymentMethodService.get(id));
    }
}
