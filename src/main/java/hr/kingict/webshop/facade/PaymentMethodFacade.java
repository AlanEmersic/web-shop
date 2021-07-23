package hr.kingict.webshop.facade;

import hr.kingict.webshop.dto.PaymentMethodDto;
import hr.kingict.webshop.form.PaymentMethodForm;

import java.util.List;

public interface PaymentMethodFacade {
    void create(PaymentMethodForm paymentMethodForm);

    PaymentMethodDto get(Long id);

    List<PaymentMethodDto> getAll();

    void delete(Long id);
}
