package hr.kingict.webshop.mapper;

import hr.kingict.webshop.dto.PaymentMethodDto;
import hr.kingict.webshop.entity.PaymentMethod;

public interface PaymentMethodDtoMapper {
    PaymentMethodDto map(PaymentMethod paymentMethod);
}
