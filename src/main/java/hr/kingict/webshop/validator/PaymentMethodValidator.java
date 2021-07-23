package hr.kingict.webshop.validator;

import hr.kingict.webshop.form.PaymentMethodForm;

public interface PaymentMethodValidator {
    void validateCreate(PaymentMethodForm form);
}
