package hr.kingict.webshop.mapper.impl;

import hr.kingict.webshop.dto.DiscountCodeDto;
import hr.kingict.webshop.entity.DiscountCode;
import hr.kingict.webshop.mapper.DiscountCodeDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DiscountCodeDtoMapperImpl implements DiscountCodeDtoMapper {
    @Override
    public DiscountCodeDto map(DiscountCode discountCode) {
        if (Objects.isNull(discountCode))
            return null;

        DiscountCodeDto dto = new DiscountCodeDto();
        dto.setId(discountCode.getId());
        dto.setCode(discountCode.getCode());
        dto.setDiscount(discountCode.getDiscount());
        dto.setUsed(discountCode.getUsed());

        return dto;
    }
}
