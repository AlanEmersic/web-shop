package hr.kingict.webshop.service.impl;

import hr.kingict.webshop.entity.PaymentMethod;
import hr.kingict.webshop.repository.PaymentMethodRepository;
import hr.kingict.webshop.service.PaymentMethodService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    @Transactional
    public void save(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod get(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("payment method doesn't exist"));
    }

    @Override
    public List<PaymentMethod> get(String name) {
        return paymentMethodRepository.findByName(name);
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public void delete(PaymentMethod paymentMethod) {
        paymentMethodRepository.delete(paymentMethod);
    }
}
