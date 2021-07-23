package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.facade.ProductFacade;
import hr.kingict.webshop.form.ProductForm;
import hr.kingict.webshop.service.BrandService;
import hr.kingict.webshop.service.ProductService;
import hr.kingict.webshop.validator.ProductValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final BrandService brandService;
    private final ProductValidator productValidator;

    public ProductFacadeImpl(ProductService productService, BrandService brandService, ProductValidator productValidator) {
        this.productService = productService;
        this.brandService = brandService;
        this.productValidator = productValidator;
    }

    @Override
    public void create(ProductForm productForm) {
        productValidator.validateCreate(productForm);

        Product product = new Product();
        BeanUtils.copyProperties(productForm, product);
        product.setBrand(brandService.get(productForm.getBrandId()));
        productService.save(product);
    }

    @Override
    public ProductDto get(Long id) {
        return Optional.of(productService.get(id)).map(product -> {
            ProductDto dto = new ProductDto();
            mapProductToDto(product, dto);

            return dto;
        }).orElse(null);
    }

    @Override
    public List<ProductDto> getAll() {
        return productService.getAll().stream().map(product -> {
            ProductDto dto = new ProductDto();
            mapProductToDto(product, dto);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        productService.delete(productService.get(id));
    }

    private void mapProductToDto(Product product, ProductDto dto) {
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
//        System.out.println(product.getBrand().getName());
        dto.setBrandId(product.getBrand().getId());
    }
}
