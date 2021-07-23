package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.DiscountCodeDto;
import hr.kingict.webshop.entity.DiscountCode;
import hr.kingict.webshop.facade.DiscountCodeFacade;
import hr.kingict.webshop.form.DiscountCodeForm;
import hr.kingict.webshop.service.DiscountCodeService;
import hr.kingict.webshop.validator.DiscountCodeValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DiscountCodeFacadeImpl implements DiscountCodeFacade {
    private final DiscountCodeService discountCodeService;
    private final DiscountCodeValidator discountCodeValidator;

    public DiscountCodeFacadeImpl(DiscountCodeService discountCodeService, DiscountCodeValidator discountCodeValidator) {
        this.discountCodeService = discountCodeService;
        this.discountCodeValidator = discountCodeValidator;
    }

    @Override
    public void create(DiscountCodeForm discountCodeForm) {
        discountCodeValidator.validateCreate(discountCodeForm);

        DiscountCode discountCode = new DiscountCode();
        BeanUtils.copyProperties(discountCodeForm, discountCode);
        discountCodeService.save(discountCode);
    }

    @Override
    public DiscountCodeDto get(Long id) {
        return Optional.of(discountCodeService.get(id)).map(discountCode -> {
            DiscountCodeDto dto = new DiscountCodeDto();
            mapDiscountCodeToDto(discountCode, dto);

            return dto;
        }).orElse(null);
    }

    @Override
    public List<DiscountCodeDto> getAll() {
        return discountCodeService.getAll().stream().map(discountCode -> {
            DiscountCodeDto dto = new DiscountCodeDto();
            mapDiscountCodeToDto(discountCode, dto);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        discountCodeService.delete(discountCodeService.get(id));
    }

    private void mapDiscountCodeToDto(DiscountCode discountCode, DiscountCodeDto dto) {
        dto.setCode(discountCode.getCode());
        dto.setDiscount(discountCode.getDiscount());
        dto.setUsed(discountCode.getUsed());
    }
}
