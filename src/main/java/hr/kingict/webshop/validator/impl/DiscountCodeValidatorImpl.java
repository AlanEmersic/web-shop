package hr.kingict.webshop.validator.impl;

import hr.kingict.webshop.entity.DiscountCode;
import hr.kingict.webshop.form.DiscountCodeForm;
import hr.kingict.webshop.service.DiscountCodeService;
import hr.kingict.webshop.validator.DiscountCodeValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountCodeValidatorImpl implements DiscountCodeValidator {
    private final DiscountCodeService discountCodeService;

    public DiscountCodeValidatorImpl(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @Override
    public void validateCreate(DiscountCodeForm form) {
        List<DiscountCode> discountCodes = discountCodeService.get(form.getCode().toLowerCase());

        if (form.getCode().trim().isEmpty() || !discountCodes.isEmpty()) {
            throw new RuntimeException("validate ex for discountCode form");
        }
    }
}
