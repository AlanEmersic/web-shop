package hr.kingict.webshop.mapper;

import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.entity.Product;

public interface ProductDtoMapper {
    ProductDto map(Product product);
}
