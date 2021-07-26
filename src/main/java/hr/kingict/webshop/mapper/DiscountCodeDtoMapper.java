package hr.kingict.webshop.mapper;

import hr.kingict.webshop.dto.DiscountCodeDto;
import hr.kingict.webshop.entity.DiscountCode;

public interface DiscountCodeDtoMapper {
    DiscountCodeDto map(DiscountCode discountCode);
}
