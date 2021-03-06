package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.facade.ProductFacade;
import hr.kingict.webshop.form.ProductForm;
import hr.kingict.webshop.mapper.ProductDtoMapper;
import hr.kingict.webshop.service.BrandService;
import hr.kingict.webshop.service.ProductService;
import hr.kingict.webshop.validator.ProductFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final BrandService brandService;
    private final ProductFormValidator productFormValidator;
    private final ProductDtoMapper productDtoMapper;
    private final List<String> validSorts = Arrays.asList("name", "brand", "price");

    public ProductFacadeImpl(ProductService productService, BrandService brandService,
                             ProductFormValidator productFormValidator, ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.brandService = brandService;
        this.productFormValidator = productFormValidator;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public void create(ProductForm productForm) {
        productFormValidator.validateCreate(productForm);

        Product product = new Product();
        BeanUtils.copyProperties(productForm, product);
        product.setBrand(brandService.get(productForm.getBrandId()));
        productService.save(product);
    }

    @Override
    public ProductDto get(Long id) {
        return productDtoMapper.map(productService.get(id));
    }

    @Override
    public List<ProductDto> getAll(String sort) {
        if (!validSorts.contains(sort))
            sort = "name";

        return productService.getAll(sort).stream().map(productDtoMapper::map).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        productService.delete(productService.get(id));
    }

}
