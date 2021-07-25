package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.BrandDto;
import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.entity.Brand;
import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.facade.BrandFacade;
import hr.kingict.webshop.form.BrandForm;
import hr.kingict.webshop.service.BrandService;
import hr.kingict.webshop.validator.BrandFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BrandFacadeImpl implements BrandFacade {

    private final BrandService brandService;
    private final BrandFormValidator brandFormValidator;

    public BrandFacadeImpl(BrandService brandService, BrandFormValidator brandFormValidator) {
        this.brandService = brandService;
        this.brandFormValidator = brandFormValidator;
    }

    @Override
    public void create(BrandForm brandForm) {
        brandFormValidator.validateCreate(brandForm);

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandForm, brand);
        brandService.save(brand);
    }

    @Override
    public BrandDto get(Long id) {
        return Optional.of(brandService.get(id)).map(brand -> {
            BrandDto dto = new BrandDto();
            mapBrandToDto(brand, dto);

            return dto;
        }).orElse(null);
    }

    @Override
    public List<BrandDto> getAll() {
        return brandService.getAll().stream().map(brand -> {
            BrandDto dto = new BrandDto();
            mapBrandToDto(brand, dto);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        brandService.delete(brandService.get(id));
    }

    private void mapBrandToDto(Brand brand, BrandDto dto) {
        dto.setId(brand.getId());
        dto.setName(brand.getName());
    }
}
