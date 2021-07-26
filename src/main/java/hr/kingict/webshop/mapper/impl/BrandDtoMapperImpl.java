package hr.kingict.webshop.mapper.impl;

import hr.kingict.webshop.dto.BrandDto;
import hr.kingict.webshop.entity.Brand;
import hr.kingict.webshop.mapper.BrandDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BrandDtoMapperImpl implements BrandDtoMapper {
    @Override
    public BrandDto map(Brand brand) {
        if (Objects.isNull(brand))
            return null;

        BrandDto dto = new BrandDto();
        dto.setId(brand.getId());
        dto.setName(brand.getName());

        return dto;
    }
}
