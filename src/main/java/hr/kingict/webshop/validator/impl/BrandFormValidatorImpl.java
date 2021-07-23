package hr.kingict.webshop.validator.impl;

import hr.kingict.webshop.entity.Brand;
import hr.kingict.webshop.form.BrandForm;
import hr.kingict.webshop.service.BrandService;
import hr.kingict.webshop.validator.BrandFormValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandFormValidatorImpl implements BrandFormValidator {
    private final BrandService brandService;

    public BrandFormValidatorImpl(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void validateCreate(BrandForm form) {
        List<Brand> brands = brandService.get(form.getName().toLowerCase());

        if (form.getName().trim().isEmpty() || !brands.isEmpty()) {
            throw new RuntimeException("validate ex for brand form");
        }
    }
}
