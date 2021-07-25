package hr.kingict.webshop.validator.impl;

import hr.kingict.webshop.form.OrderProductsForm;
import hr.kingict.webshop.service.ProductService;
import hr.kingict.webshop.validator.OrderProductsFormValidator;
import org.springframework.stereotype.Component;

@Component
public class OrderProductsFormValidatorImpl implements OrderProductsFormValidator {
    private final ProductService productService;

    public OrderProductsFormValidatorImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void validateCreate(OrderProductsForm form) {
        if (productService.get(form.getProductId()).getQuantity() == 0) {
            throw new RuntimeException("product quantity is 0");
        }
    }
}
