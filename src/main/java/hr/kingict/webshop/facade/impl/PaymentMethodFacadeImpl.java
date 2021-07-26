package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.PaymentMethodDto;
import hr.kingict.webshop.entity.PaymentMethod;
import hr.kingict.webshop.facade.PaymentMethodFacade;
import hr.kingict.webshop.form.PaymentMethodForm;
import hr.kingict.webshop.mapper.PaymentMethodDtoMapper;
import hr.kingict.webshop.service.PaymentMethodService;
import hr.kingict.webshop.validator.PaymentMethodFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PaymentMethodFacadeImpl implements PaymentMethodFacade {
    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodFormValidator paymentMethodFormValidator;
    private final PaymentMethodDtoMapper paymentMethodDtoMapper;

    public PaymentMethodFacadeImpl(PaymentMethodService paymentMethodService,
                                   PaymentMethodFormValidator paymentMethodFormValidator,
                                   PaymentMethodDtoMapper paymentMethodDtoMapper) {
        this.paymentMethodService = paymentMethodService;
        this.paymentMethodFormValidator = paymentMethodFormValidator;
        this.paymentMethodDtoMapper = paymentMethodDtoMapper;
    }

    @Override
    public void create(PaymentMethodForm paymentMethodForm) {
        paymentMethodFormValidator.validateCreate(paymentMethodForm);

        PaymentMethod paymentMethod = new PaymentMethod();
        BeanUtils.copyProperties(paymentMethodForm, paymentMethod);
        paymentMethodService.save(paymentMethod);
    }

    @Override
    public PaymentMethodDto get(Long id) {
        return paymentMethodDtoMapper.map(paymentMethodService.get(id));
    }

    @Override
    public List<PaymentMethodDto> getAll() {
        return paymentMethodService.getAll().stream().map(paymentMethodDtoMapper::map).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        paymentMethodService.delete(paymentMethodService.get(id));
    }
}
