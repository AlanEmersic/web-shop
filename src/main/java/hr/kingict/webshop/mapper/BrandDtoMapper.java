package hr.kingict.webshop.mapper;

import hr.kingict.webshop.dto.BrandDto;
import hr.kingict.webshop.entity.Brand;

public interface BrandDtoMapper {
    BrandDto map(Brand brand);
}
