package hr.kingict.webshop.validator.impl;

import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.form.ProductForm;
import hr.kingict.webshop.service.ProductService;
import hr.kingict.webshop.validator.ProductFormValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFormValidatorImpl implements ProductFormValidator {
    private final ProductService productService;

    public ProductFormValidatorImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void validateCreate(ProductForm form) {
        List<Product> products = productService.get(form.getName().toLowerCase());

        if (form.getName().trim().isEmpty() || !products.isEmpty()) {
            throw new RuntimeException("validate ex for product form");
        }
    }
}
