package hr.kingict.webshop.service;

import hr.kingict.webshop.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    void save(PaymentMethod paymentMethod);

    PaymentMethod get(Long id);

    List<PaymentMethod> get(String name);

    List<PaymentMethod> getAll();

    void delete(PaymentMethod paymentMethod);
}
