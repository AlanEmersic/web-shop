package hr.kingict.webshop.service;

import hr.kingict.webshop.entity.DiscountCode;

import java.util.List;

public interface DiscountCodeService {
    void save(DiscountCode discountCode);

    DiscountCode get(Long id);

    DiscountCode getByCode(String code);

    List<DiscountCode> get(String code);

    List<DiscountCode> getAll();

    void delete(DiscountCode discountCode);
}
