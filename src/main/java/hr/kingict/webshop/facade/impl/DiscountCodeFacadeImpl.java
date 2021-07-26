package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.DiscountCodeDto;
import hr.kingict.webshop.entity.DiscountCode;
import hr.kingict.webshop.facade.DiscountCodeFacade;
import hr.kingict.webshop.form.DiscountCodeForm;
import hr.kingict.webshop.mapper.DiscountCodeDtoMapper;
import hr.kingict.webshop.service.DiscountCodeService;
import hr.kingict.webshop.validator.DiscountCodeFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DiscountCodeFacadeImpl implements DiscountCodeFacade {
    private final DiscountCodeService discountCodeService;
    private final DiscountCodeFormValidator discountCodeFormValidator;
    private final DiscountCodeDtoMapper discountCodeDtoMapper;

    public DiscountCodeFacadeImpl(DiscountCodeService discountCodeService,
                                  DiscountCodeFormValidator discountCodeFormValidator,
                                  DiscountCodeDtoMapper discountCodeDtoMapper) {
        this.discountCodeService = discountCodeService;
        this.discountCodeFormValidator = discountCodeFormValidator;
        this.discountCodeDtoMapper = discountCodeDtoMapper;
    }

    @Override
    public void create(DiscountCodeForm discountCodeForm) {
        discountCodeFormValidator.validateCreate(discountCodeForm);

        DiscountCode discountCode = new DiscountCode();
        BeanUtils.copyProperties(discountCodeForm, discountCode);
        discountCodeService.save(discountCode);
    }

    @Override
    public DiscountCodeDto get(Long id) {
        return discountCodeDtoMapper.map(discountCodeService.get(id));
    }

    @Override
    public DiscountCodeDto getByCode(String code) {
        return discountCodeDtoMapper.map(discountCodeService.getByCode(code));
    }

    @Override
    public List<DiscountCodeDto> getAll() {
        return discountCodeService.getAll().stream().map(discountCodeDtoMapper::map).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        discountCodeService.delete(discountCodeService.get(id));
    }

}
