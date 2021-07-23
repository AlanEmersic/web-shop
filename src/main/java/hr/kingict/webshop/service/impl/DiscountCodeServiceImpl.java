package hr.kingict.webshop.service.impl;

import hr.kingict.webshop.entity.DiscountCode;
import hr.kingict.webshop.repository.DiscountCodeRepository;
import hr.kingict.webshop.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {
    private final DiscountCodeRepository discountCodeRepository;

    public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    @Transactional
    public void save(DiscountCode discountCode) {
        discountCodeRepository.save(discountCode);
    }

    @Override
    public DiscountCode get(Long id) {
        return discountCodeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("code doesn't exist"));
    }

    @Override
    public List<DiscountCode> get(String code) {
        return discountCodeRepository.findAllByCode(code);
    }

    @Override
    public List<DiscountCode> getAll() {
        return discountCodeRepository.findAll();
    }

    @Override
    public void delete(DiscountCode discountCode) {
        discountCodeRepository.delete(discountCode);
    }
}
