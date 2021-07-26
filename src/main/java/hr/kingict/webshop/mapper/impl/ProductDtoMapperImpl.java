package hr.kingict.webshop.mapper.impl;

import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.mapper.ProductDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductDtoMapperImpl implements ProductDtoMapper {
    @Override
    public ProductDto map(Product product) {
        if (Objects.isNull(product))
            return null;

        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setBrandId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setBrandId(product.getBrand().getId());

        return dto;
    }
}
