package hr.kingict.webshop.mapper.impl;

import hr.kingict.webshop.dto.PaymentMethodDto;
import hr.kingict.webshop.entity.PaymentMethod;
import hr.kingict.webshop.mapper.PaymentMethodDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PaymentMethodDtoMapperImpl implements PaymentMethodDtoMapper {
    @Override
    public PaymentMethodDto map(PaymentMethod paymentMethod) {
        if (Objects.isNull(paymentMethod))
            return null;

        PaymentMethodDto dto = new PaymentMethodDto();
        dto.setName(paymentMethod.getName());

        return dto;
    }
}
