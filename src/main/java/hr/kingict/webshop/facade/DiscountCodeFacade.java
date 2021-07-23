package hr.kingict.webshop.facade;

import hr.kingict.webshop.dto.DiscountCodeDto;
import hr.kingict.webshop.form.DiscountCodeForm;

import java.util.List;

public interface DiscountCodeFacade {
    void create(DiscountCodeForm discountCodeForm);

    DiscountCodeDto get(Long id);

    List<DiscountCodeDto> getAll();

    void delete(Long id);
}
