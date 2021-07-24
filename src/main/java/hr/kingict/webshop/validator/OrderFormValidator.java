package hr.kingict.webshop.validator;

import hr.kingict.webshop.form.OrderForm;

public interface OrderFormValidator {
    void validateCreate(OrderForm form);
}
